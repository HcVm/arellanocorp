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

import com.acorporation.app.dto.ActualizarRolDTO;
import com.acorporation.app.dto.CrearRolDTO;
import com.acorporation.app.dto.RolDTO;
import com.acorporation.app.services.RolServicio;

@RestController
@RequestMapping("/roles")
public class RolControlador {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping
    public ResponseEntity<List<RolDTO>> listarRoles() {
        return ResponseEntity.ok(rolServicio.obtenerTodosLosRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerRol(@PathVariable Integer id) {
        RolDTO rol = rolServicio.obtenerRolPorId(id);
        return (rol != null) ? ResponseEntity.ok(rol) : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable Integer id, @RequestBody ActualizarRolDTO actualizarRolDTO) {
        RolDTO rolActualizado = rolServicio.actualizarRol(id, actualizarRolDTO);
        return (rolActualizado != null) ? ResponseEntity.ok(rolActualizado) : ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<RolDTO> crearRol(@RequestBody CrearRolDTO  crearRolDTO ) {
        RolDTO nuevoRol = rolServicio.crearRol(crearRolDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        rolServicio.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
