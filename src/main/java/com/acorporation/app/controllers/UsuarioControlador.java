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

import com.acorporation.app.dto.ActualizarUsuarioDTO;
import com.acorporation.app.dto.CrearUsuarioDTO;
import com.acorporation.app.dto.UsuarioDTO;
import com.acorporation.app.services.UsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Integer id) {
        UsuarioDTO usuario = usuarioServicio.obtenerUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody CrearUsuarioDTO crearUsuarioDTO) {
        UsuarioDTO usuarioCreado = usuarioServicio.crearUsuario(crearUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody ActualizarUsuarioDTO actualizarUsuarioDTO) {
    	
    	System.out.println("ID recibido en la API: " + id);
        UsuarioDTO usuarioActualizado = usuarioServicio.actualizarUsuario(id, actualizarUsuarioDTO);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}/estado")
    public ResponseEntity<UsuarioDTO> cambiarEstadoUsuario(@PathVariable Integer id) {
        UsuarioDTO usuarioActualizado = usuarioServicio.cambiarEstado(id);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuarioServicio.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}