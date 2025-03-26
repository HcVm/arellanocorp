package com.acorporation.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorporation.app.services.UsuarioDetailsService;
import com.acorporation.app.utilities.JwtUtil;
import com.acorporation.app.dto.AuthRequest;
import com.acorporation.app.dto.AuthResponse;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.UsuarioRepositorio;



@RestController
@RequestMapping("/auth")
public class AuthControlador {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepositorio usuarioRepositorio;

    public AuthControlador(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil,
            UsuarioDetailsService usuarioDetailsService,
            UsuarioRepositorio usuarioRepositorio) {
            this.authenticationManager = authenticationManager;
            this.jwtUtil = jwtUtil;
            this.usuarioRepositorio = usuarioRepositorio;
        }
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        // Obtener datos del usuario
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(authRequest.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        final String jwt = jwtUtil.generateToken(usuario.getNombreUsuario());

        // Devolvemos el token y los datos básicos del usuario
        return ResponseEntity.ok(new AuthResponse(jwt, usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getRol().getNombreRol()));
    }
}

