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

import com.acorporation.app.dto.DistribuidorDTO;
import com.acorporation.app.services.DistribuidorServicio;

@RestController
@RequestMapping("/distribuidores")
public class DistribuidorControlador {

    @Autowired 
    private DistribuidorServicio distribuidorServicio;

    @GetMapping
    public ResponseEntity<List<DistribuidorDTO>> listarDistribuidores() {
        List<DistribuidorDTO> distribuidores = distribuidorServicio.obtenerTodosLosDistribuidores();
        return ResponseEntity.ok(distribuidores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistribuidorDTO> obtenerDistribuidor(@PathVariable Integer id) {
        DistribuidorDTO distribuidor = distribuidorServicio.obtenerDistribuidorPorId(id);
        return (distribuidor != null) ? ResponseEntity.ok(distribuidor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DistribuidorDTO> crearDistribuidor(@RequestBody DistribuidorDTO distribuidorDTO) {
        DistribuidorDTO nuevoDistribuidor = distribuidorServicio.crearDistribuidor(distribuidorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDistribuidor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistribuidorDTO> actualizarDistribuidor(@PathVariable Integer id, @RequestBody DistribuidorDTO distribuidorDTO) {
        DistribuidorDTO distribuidorActualizado = distribuidorServicio.actualizarDistribuidor(id, distribuidorDTO);
        return (distribuidorActualizado != null) ? ResponseEntity.ok(distribuidorActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDistribuidor(@PathVariable Integer id) {
        distribuidorServicio.eliminarDistribuidor(id);
        return ResponseEntity.noContent().build();
    }
}
