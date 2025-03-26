package com.acorporation.app.utilities;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.acorporation.app.models.Rol;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.RolRepositorio;
import com.acorporation.app.repositories.UsuarioRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        crearAdministradorSiNoExiste();
    }

    private void crearAdministradorSiNoExiste() {
        // Verificar si ya existe un usuario administrador
        Optional<Usuario> adminExistente = usuarioRepositorio.findByNombreUsuario("admin");

        if (adminExistente.isEmpty()) {
            System.out.println("🔹 Creando usuario administrador...");

            // Buscar o crear el rol ADMIN
            Rol rolAdmin = rolRepositorio.findByNombreRol("ADMINISTRADOR").orElseGet(() -> {
                Rol nuevoRol = new Rol();
                nuevoRol.setNombreRol("ADMINISTRADOR");
                return rolRepositorio.save(nuevoRol);
            });

            // Crear usuario administrador
            Usuario admin = new Usuario();
            admin.setNombreUsuario("admin");
            admin.setContrasenaHash(passwordEncoder.encode("admin123")); // Encripta la contraseña
            admin.setNombreCompleto("Administrador del Sistema");
            admin.setEmail("admin@example.com");
            admin.setFechaCreacion(new Date());
            admin.setActivo(true);
            admin.setRol(rolAdmin);

            usuarioRepositorio.save(admin);
            System.out.println("✅ Usuario administrador creado con éxito.");
        } else {
            System.out.println("✅ Usuario administrador ya existe.");
        }
    }
}
