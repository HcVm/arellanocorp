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

import com.acorporation.app.dto.CaracteristicaDTO;
import com.acorporation.app.services.CaracteristicaServicio;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaControlador {

    @Autowired
    private CaracteristicaServicio caracteristicaServicio;

    @GetMapping
    public List<CaracteristicaDTO> obtenerTodasLasCaracteristicas() {
        return caracteristicaServicio.obtenerTodasLasCaracteristicas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaDTO> obtenerCaracteristicaPorId(@PathVariable Integer id) {
        CaracteristicaDTO caracteristicaDTO = caracteristicaServicio.obtenerCaracteristicaPorId(id);
        return caracteristicaDTO != null ? ResponseEntity.ok(caracteristicaDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CaracteristicaDTO> crearCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO) {
        CaracteristicaDTO nuevaCaracteristica = caracteristicaServicio.crearCaracteristica(caracteristicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCaracteristica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaracteristicaDTO> actualizarCaracteristica(
            @PathVariable Integer id, @RequestBody CaracteristicaDTO caracteristicaDTO) {
        CaracteristicaDTO actualizada = caracteristicaServicio.actualizarCaracteristica(id, caracteristicaDTO);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCaracteristica(@PathVariable Integer id) {
        caracteristicaServicio.eliminarCaracteristica(id);
        return ResponseEntity.noContent().build();
    }
}
