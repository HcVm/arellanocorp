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

import com.acorporation.app.dto.MarcaDTO;
import com.acorporation.app.services.MarcaServicio;

@RestController
@RequestMapping("/marcas")
public class MarcaControlador {

    @Autowired
    private MarcaServicio marcaServicio;

    @PostMapping
    public ResponseEntity<MarcaDTO> crearMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaDTO nuevaMarca = marcaServicio.crearMarca(marcaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMarca);
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> obtenerTodasLasMarcas() {
        List<MarcaDTO> marcas = marcaServicio.obtenerTodasLasMarcas();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorId(@PathVariable Integer id) {
        MarcaDTO marca = marcaServicio.obtenerMarcaPorId(id);
        return (marca != null) ? ResponseEntity.ok(marca) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> actualizarMarca(@PathVariable Integer id, @RequestBody MarcaDTO marcaDTO) {
        MarcaDTO marcaActualizada = marcaServicio.actualizarMarca(id, marcaDTO);
        return (marcaActualizada != null) ? ResponseEntity.ok(marcaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Integer id) {
        marcaServicio.eliminarMarca(id);
        return ResponseEntity.noContent().build();
    }
}

