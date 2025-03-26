package com.acorporation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorporation.app.dto.PermisoDTO;
import com.acorporation.app.services.PermisoServicio;

@RestController
@RequestMapping("/permisos")
public class PermisoControlador {

    @Autowired
    private PermisoServicio permisoServicio;

    @GetMapping
    public ResponseEntity<List<PermisoDTO>> listarPermisos() {
        return ResponseEntity.ok(permisoServicio.obtenerTodosLosPermisos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisoDTO> obtenerPermiso(@PathVariable Integer id) {
        PermisoDTO permiso = permisoServicio.obtenerPermisoPorId(id);
        return (permiso != null) ? ResponseEntity.ok(permiso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PermisoDTO> crearPermiso(@RequestBody PermisoDTO permisoDTO) {
        PermisoDTO nuevoPermiso = permisoServicio.crearPermiso(permisoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPermiso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable Integer id) {
        permisoServicio.eliminarPermiso(id);
        return ResponseEntity.noContent().build();
    }
}
