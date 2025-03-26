package com.acorporation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorporation.app.dto.MovimientoDocumentoDTO;
import com.acorporation.app.models.MovimientoDocumento;
import com.acorporation.app.services.MovimientoDocumentoServicio;

@RestController
@RequestMapping("/movimientos")
public class MovimientoDocumentoControlador {

    @Autowired
    private MovimientoDocumentoServicio movimientoDocumentoServicio;

    @PostMapping("/registrar")
    public ResponseEntity<MovimientoDocumento> registrarMovimiento(
            @RequestParam Integer idDocumento,
            @RequestParam Integer idDepartamentoOrigen,
            @RequestParam Integer idDepartamentoDestino,
            @RequestParam Integer idUsuarioEnvia,
            @RequestParam Integer idUsuarioRecibe,
            @RequestParam String comentarios) {
        
        MovimientoDocumento movimiento = movimientoDocumentoServicio.registrarMovimiento(
                idDocumento, idDepartamentoOrigen, idDepartamentoDestino, idUsuarioEnvia, idUsuarioRecibe, comentarios);
        
        return ResponseEntity.ok(movimiento);
    }

    @GetMapping("/{idDocumento}")
    public ResponseEntity<List<MovimientoDocumentoDTO>> obtenerMovimientosPorDocumento(@PathVariable Integer idDocumento) {
        return ResponseEntity.ok(movimientoDocumentoServicio.obtenerMovimientosPorDocumento(idDocumento));
    }
}
