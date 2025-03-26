package com.acorporation.app.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.DepartamentoLiteDTO;
import com.acorporation.app.dto.DocumentoDTO;
import com.acorporation.app.dto.MovimientoDocumentoDTO;
import com.acorporation.app.dto.UsuarioLiteDTO;
import com.acorporation.app.models.Departamento;
import com.acorporation.app.models.Documento;
import com.acorporation.app.models.MovimientoDocumento;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.DepartamentoRepositorio;
import com.acorporation.app.repositories.DocumentoRepositorio;
import com.acorporation.app.repositories.MovimientoDocumentoRepositorio;
import com.acorporation.app.repositories.UsuarioRepositorio;


@Service
public class MovimientoDocumentoServicio {

    @Autowired
    private MovimientoDocumentoRepositorio movimientoDocumentoRepositorio;

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public MovimientoDocumento registrarMovimiento(Integer idDocumento, 
                                                   Integer idDepartamentoOrigen, 
                                                   Integer idDepartamentoDestino, 
                                                   Integer idUsuarioEnvia, 
                                                   Integer idUsuarioRecibe, 
                                                   String comentarios) {
        // Verificar que los datos existen en la base de datos
        Documento documento = documentoRepositorio.findById(idDocumento)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        Departamento departamentoOrigen = departamentoRepositorio.findById(idDepartamentoOrigen)
                .orElseThrow(() -> new RuntimeException("Departamento de origen no encontrado"));

        Departamento departamentoDestino = departamentoRepositorio.findById(idDepartamentoDestino)
                .orElseThrow(() -> new RuntimeException("Departamento de destino no encontrado"));

        Usuario usuarioEnvia = usuarioRepositorio.findById(idUsuarioEnvia)
                .orElseThrow(() -> new RuntimeException("Usuario que envía no encontrado"));

        Usuario usuarioRecibe = usuarioRepositorio.findById(idUsuarioRecibe)
                .orElseThrow(() -> new RuntimeException("Usuario que recibe no encontrado"));

        // Crear movimiento
        MovimientoDocumento movimiento = new MovimientoDocumento();
        movimiento.setDocumento(documento);
        movimiento.setDepartamentoOrigen(departamentoOrigen);
        movimiento.setDepartamentoDestino(departamentoDestino);
        movimiento.setUsuarioEnvia(usuarioEnvia);
        movimiento.setUsuarioRecibe(usuarioRecibe);
        movimiento.setFechaMovimiento(new Date());
        movimiento.setComentarios(comentarios);

        // Guardar en base de datos
        return movimientoDocumentoRepositorio.save(movimiento);
    }

    public List<MovimientoDocumentoDTO> obtenerMovimientosPorDocumento(Integer idDocumento) {
        List<MovimientoDocumento> movimientos = movimientoDocumentoRepositorio.findByDocumentoIdDocumento(idDocumento);
        return movimientos.stream().map(this::convertirMovimientoADTO).collect(Collectors.toList());
    }

    // Agregar este método en MovimientoDocumentoServicio para convertir la entidad a DTO
    private MovimientoDocumentoDTO convertirMovimientoADTO(MovimientoDocumento movimiento) {
        return new MovimientoDocumentoDTO(
            movimiento.getIdMovimiento(),
            new DocumentoDTO(movimiento.getDocumento().getIdDocumento()), // O ajusta según sea necesario
            new DepartamentoLiteDTO(movimiento.getDepartamentoOrigen().getIdDepartamento(), movimiento.getDepartamentoOrigen().getNombreDepartamento()),
            new DepartamentoLiteDTO(movimiento.getDepartamentoDestino().getIdDepartamento(), movimiento.getDepartamentoDestino().getNombreDepartamento()),
            new UsuarioLiteDTO(movimiento.getUsuarioEnvia().getIdUsuario(), movimiento.getUsuarioEnvia().getNombreUsuario()),
            new UsuarioLiteDTO(movimiento.getUsuarioRecibe().getIdUsuario(), movimiento.getUsuarioRecibe().getNombreUsuario()),
            movimiento.getFechaMovimiento(),
            movimiento.getComentarios()
        );
    }
    
    




}