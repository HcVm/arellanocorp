package com.acorporation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorporation.app.dto.ValorCaracteristicaDTO;
import com.acorporation.app.services.ValorCaracteristicaServicio;

@RestController
@RequestMapping("/valores-caracteristicas")
public class ValorCaracteristicaControlador {

    @Autowired
    private ValorCaracteristicaServicio valorCaracteristicaServicio;

    @GetMapping
    public List<ValorCaracteristicaDTO> obtenerTodosLosValores() {
        return valorCaracteristicaServicio.obtenerTodosLosValores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValorCaracteristicaDTO> obtenerValorPorId(@PathVariable Integer id) {
        ValorCaracteristicaDTO valorDTO = valorCaracteristicaServicio.obtenerValorPorId(id);
        return valorDTO != null ? ResponseEntity.ok(valorDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ValorCaracteristicaDTO> crearValorCaracteristica(@RequestBody ValorCaracteristicaDTO valorCaracteristicaDTO) {
        ValorCaracteristicaDTO nuevoValor = valorCaracteristicaServicio.crearValorCaracteristica(valorCaracteristicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoValor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValorCaracteristicaDTO> actualizarValorCaracteristica(
            @PathVariable Integer id, @RequestBody ValorCaracteristicaDTO valorCaracteristicaDTO) {
        ValorCaracteristicaDTO actualizado = valorCaracteristicaServicio.actualizarValorCaracteristica(id, valorCaracteristicaDTO);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarValorCaracteristica(@PathVariable Integer id) {
        valorCaracteristicaServicio.eliminarValorCaracteristica(id);
        return ResponseEntity.noContent().build();
    }
}
