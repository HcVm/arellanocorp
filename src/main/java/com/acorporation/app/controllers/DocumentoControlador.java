package com.acorporation.app.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ContentDisposition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.acorporation.app.dto.DepartamentoLiteDTO;
import com.acorporation.app.dto.DocumentoDTO;
import com.acorporation.app.dto.MoverDocumentoDTO;
import com.acorporation.app.dto.UsuarioDTO;
import com.acorporation.app.models.Departamento;
import com.acorporation.app.models.Documento;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.DepartamentoRepositorio;
import com.acorporation.app.repositories.DocumentoRepositorio;
import com.acorporation.app.repositories.UsuarioRepositorio;
import com.acorporation.app.services.DocumentoServicio;
import com.acorporation.app.services.MovimientoDocumentoServicio;


@RestController
@RequestMapping("/documentos")
public class DocumentoControlador {

    @Autowired
    private DocumentoServicio documentoServicio;
    
    @Autowired
    private DocumentoRepositorio documentoRepositorio;
    
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private MovimientoDocumentoServicio movimientoDocumentoServicio;
    
    
    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> listarDocumentos() {
        List<DocumentoDTO> documentos = documentoServicio.obtenerTodosLosDocumentos();
        return ResponseEntity.ok(documentos);
    }


    /**
     * Endpoint para subir un documento, guardarlo en la base de datos y registrar su movimiento.
     * 
     * @param archivo Archivo a subir
     * @param tipoDocumento Tipo de documento
     * @param numeroDocumento Número del documento
     * @param idDepartamentoActual ID del departamento actual
     * @param idUsuarioActual ID del usuario actual
     * @param idDepartamentoDestino ID del departamento destino
     * @param idUsuarioRecibe ID del usuario que recibe
     * @param comentarios Comentarios sobre el movimiento
     * @return Documento guardado con el ID de Google Drive y su movimiento registrado
     */
    @PostMapping("/subir")
    public ResponseEntity<?> subirDocumento(
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("numeroDocumento") String numeroDocumento,
            @RequestParam("idDepartamentoActual") Integer idDepartamentoActual,
            @RequestParam("idUsuarioActual") Integer idUsuarioActual,
            @RequestParam("idDepartamentoDestino") Integer idDepartamentoDestino,
            @RequestParam("idUsuarioRecibe") Integer idUsuarioRecibe,
            @RequestParam("comentarios") String comentarios) throws IOException, GeneralSecurityException {

        try {
        	DocumentoDTO documentoDTO = documentoServicio.guardarDocumento(archivo, tipoDocumento, numeroDocumento, 
                    idDepartamentoActual, idUsuarioActual, 
                    idDepartamentoDestino, idUsuarioRecibe, comentarios);

            Map<String, Object> response = new HashMap<>();
            response.put("documento", documentoDTO);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar el archivo: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Endpoint para descargar un documento desde Google Drive.
     * 
     * @param idDocumento ID del documento en la base de datos
     * @return Archivo descargado desde Google Drive
     */
    @GetMapping("/descargar/{idDocumento}")
    public ResponseEntity<byte[]> descargarDocumento(@PathVariable Integer idDocumento) {
        try {
            System.out.println("Intentando descargar documento con ID: " + idDocumento);

            byte[] contenido = documentoServicio.obtenerDocumento(idDocumento);
            
            if (contenido == null || contenido.length == 0) {
                System.out.println("Documento no encontrado o vacío.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename("documento_" + idDocumento + ".pdf")
                    .build());

            System.out.println("Documento encontrado y listo para descargar.");
            return ResponseEntity.ok().headers(headers).body(contenido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @PutMapping("/mover")
    public ResponseEntity<?> moverDocumento(@RequestBody MoverDocumentoDTO moverDocumentoDTO) {
        try {
            // 1. Obtener el documento
            Documento documento = documentoRepositorio.findById(moverDocumentoDTO.getIdDocumento())
                    .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

            // 2. Obtener el departamento de destino
            Departamento departamentoDestino = departamentoRepositorio.findById(moverDocumentoDTO.getIdDepartamentoDestino())
                    .orElseThrow(() -> new RuntimeException("Departamento destino no encontrado"));

            // 3. Obtener el usuario que recibirá el documento
            Usuario usuarioRecibe = usuarioRepositorio.findById(moverDocumentoDTO.getIdUsuarioRecibe())
                    .orElseThrow(() -> new RuntimeException("Usuario que recibe no encontrado"));

            // 4. Registrar el movimiento del documento
            movimientoDocumentoServicio.registrarMovimiento(
                    documento.getIdDocumento(),
                    documento.getDepartamentoActual().getIdDepartamento(),  // Departamento origen
                    departamentoDestino.getIdDepartamento(),  // Departamento destino
                    documento.getUsuarioActual().getIdUsuario(),  // Usuario que envía
                    usuarioRecibe.getIdUsuario(),  // Usuario que recibe
                    moverDocumentoDTO.getComentarios()
            );

            // 6. Retornar la respuesta con el documento actualizado
            return ResponseEntity.ok(convertirDocumentoADTO(documento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al mover el documento: " + e.getMessage());
        }
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



}
