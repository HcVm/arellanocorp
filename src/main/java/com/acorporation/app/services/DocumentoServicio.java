package com.acorporation.app.services;

import com.acorporation.app.dto.DepartamentoLiteDTO;
import com.acorporation.app.dto.DocumentoDTO;
import com.acorporation.app.dto.MovimientoDocumentoDTO;
import com.acorporation.app.dto.UsuarioDTO;
import com.acorporation.app.models.Departamento;
import com.acorporation.app.models.Documento;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.DepartamentoRepositorio;
import com.acorporation.app.repositories.DocumentoRepositorio;
import com.acorporation.app.repositories.UsuarioRepositorio;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.api.services.drive.model.File;

import jakarta.transaction.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoServicio {

    @Autowired
    private GoogleDriveServicio googleDriveServicio;

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private MovimientoDocumentoServicio movimientoDocumentoServicio;

    public DocumentoDTO guardarDocumento(MultipartFile archivo, 
            String tipoDocumento, 
            String numeroDocumento, 
            Integer idDepartamentoActual, 
            Integer idUsuarioActual, 
            Integer idDepartamentoDestino, 
            Integer idUsuarioRecibe, 
            String comentarios) throws IOException, GeneralSecurityException {

        // 1. Guardar el archivo en Google Drive
        String fileId = guardarArchivoEnDrive(archivo);

        // 2. Obtener las entidades necesarias (una sola vez)
        Departamento departamentoActual = departamentoRepositorio.findById(idDepartamentoActual)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        Usuario usuarioActual = usuarioRepositorio.findById(idUsuarioActual)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Departamento departamentoDestino = departamentoRepositorio.findById(idDepartamentoDestino)
                .orElseThrow(() -> new RuntimeException("Departamento destino no encontrado"));
        Usuario usuarioRecibe = usuarioRepositorio.findById(idUsuarioRecibe)
                .orElseThrow(() -> new RuntimeException("Usuario que recibe no encontrado"));

        // 3. Crear y guardar el documento
        Documento documento = new Documento();
        documento.setTipoDocumento(tipoDocumento);
        documento.setNumeroDocumento(numeroDocumento);
        documento.setFechaDocumento(new Date());
        documento.setRutaArchivo(fileId);
        documento.setDepartamentoActual(departamentoActual);
        documento.setUsuarioActual(usuarioActual);

        documento = documentoRepositorio.save(documento);

        // 4. Registrar el movimiento usando las entidades ya obtenidas
        movimientoDocumentoServicio.registrarMovimiento(
            documento.getIdDocumento(),
            departamentoActual.getIdDepartamento(),
            departamentoDestino.getIdDepartamento(),
            usuarioActual.getIdUsuario(),
            usuarioRecibe.getIdUsuario(),
            comentarios
        );

        return convertirDocumentoADTO(documento);
    }

    private DocumentoDTO convertirDocumentoADTO(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setIdDocumento(documento.getIdDocumento());
        dto.setTipoDocumento(documento.getTipoDocumento());
        dto.setNumeroDocumento(documento.getNumeroDocumento());
        dto.setFechaDocumento(documento.getFechaDocumento());
        dto.setRutaArchivo(documento.getRutaArchivo());

        if (documento.getDepartamentoActual() != null) {
            dto.setDepartamentoActual(convertirDepartamentoALiteDTO(documento.getDepartamentoActual()));
        }
        if (documento.getUsuarioActual() != null) {
            dto.setUsuarioActual(convertirUsuarioADTO(documento.getUsuarioActual()));
        }

        // Obtener movimientos del documento
        List<MovimientoDocumentoDTO> movimientosDTO = movimientoDocumentoServicio.obtenerMovimientosPorDocumento(documento.getIdDocumento());
        dto.setMovimientos(movimientosDTO);

        return dto;
    }
    
    private DepartamentoLiteDTO convertirDepartamentoALiteDTO(Departamento departamento) {
        DepartamentoLiteDTO dto = new DepartamentoLiteDTO();
        dto.setIdDepartamento(departamento.getIdDepartamento());
        dto.setNombreDepartamento(departamento.getNombreDepartamento());
        return dto;
    }
    
    private UsuarioDTO convertirUsuarioADTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setActivo(usuario.getActivo());

        if (usuario.getDepartamento() != null) {
            usuarioDTO.setDepartamentoDocumento(convertirDepartamentoALiteDTO(usuario.getDepartamento()));
        }

        return usuarioDTO;
    }

    private String guardarArchivoEnDrive(MultipartFile archivo) throws IOException, GeneralSecurityException {
        Drive service = googleDriveServicio.getDriveService();

        // Guardar el archivo temporalmente en discos
        java.io.File tempFile = java.io.File.createTempFile("upload-", archivo.getOriginalFilename());
        archivo.transferTo(tempFile);

        File fileMetadata = new File();
        fileMetadata.setName(archivo.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList("root"));

        FileContent mediaContent = new FileContent(archivo.getContentType(), tempFile);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        // Eliminar el archivo temporal después de la subida
        tempFile.delete();

        System.out.println("File ID: " + file.getId());
        return file.getId();
    }
    
    public List<DocumentoDTO> obtenerTodosLosDocumentos() {
        List<Documento> documentos = documentoRepositorio.findAll();

        return documentos.stream()
                .map(this::convertirDocumentoADTO)
                .collect(Collectors.toList());
    }

    public byte[] obtenerDocumento(Integer idDocumento) throws IOException, GeneralSecurityException {
        Documento documento = documentoRepositorio.findById(idDocumento)
                .orElseThrow(() -> new FileNotFoundException("Documento no encontrado con ID: " + idDocumento));
        return obtenerArchivoDeDrive(documento.getRutaArchivo());
    }

    private byte[] obtenerArchivoDeDrive(String fileId) throws IOException, GeneralSecurityException {
        Drive service = googleDriveServicio.getDriveService();
        return service.files().get(fileId).executeMediaAsInputStream().readAllBytes();
    }
    
    @Transactional
    public DocumentoDTO moverDocumento(Integer idDocumento, Integer idDepartamentoDestino, Integer idUsuarioRecibe, String comentarios) {
        Documento documento = documentoRepositorio.findById(idDocumento)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        Departamento departamentoActual = documento.getDepartamentoActual();
        Usuario usuarioActual = documento.getUsuarioActual();

        Departamento departamentoDestino = departamentoRepositorio.findById(idDepartamentoDestino)
                .orElseThrow(() -> new RuntimeException("Departamento destino no encontrado"));
        Usuario usuarioRecibe = usuarioRepositorio.findById(idUsuarioRecibe)
                .orElseThrow(() -> new RuntimeException("Usuario receptor no encontrado"));

        movimientoDocumentoServicio.registrarMovimiento(
            documento.getIdDocumento(),
            departamentoActual.getIdDepartamento(),
            departamentoDestino.getIdDepartamento(),
            usuarioActual.getIdUsuario(),
            usuarioRecibe.getIdUsuario(),
            comentarios
        );

        documento.setDepartamentoActual(departamentoDestino);
        documento.setUsuarioActual(usuarioRecibe);
        documentoRepositorio.save(documento);

        return convertirDocumentoADTO(documento);
    }
}
