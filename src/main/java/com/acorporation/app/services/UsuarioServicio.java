package com.acorporation.app.services;

import com.acorporation.app.dto.ActualizarUsuarioDTO;
import com.acorporation.app.dto.CrearUsuarioDTO;
import com.acorporation.app.dto.DepartamentoDTO;
import com.acorporation.app.dto.EmpresaLiteDTO;
import com.acorporation.app.dto.RolDTO;
import com.acorporation.app.dto.UsuarioDTO;
import com.acorporation.app.models.Departamento;
import com.acorporation.app.models.Rol;
import com.acorporation.app.models.Usuario;
import com.acorporation.app.repositories.DepartamentoRepositorio;
import com.acorporation.app.repositories.RolRepositorio;
import com.acorporation.app.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAllWithRelations();
        return usuarios.stream().map(this::convertirUsuarioADTO).collect(Collectors.toList());
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        return usuario.map(this::convertirUsuarioADTO).orElse(null);
    }

    public UsuarioDTO crearUsuario(CrearUsuarioDTO crearUsuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(crearUsuarioDTO.getNombreUsuario());
        usuario.setContrasenaHash(passwordEncoder.encode(crearUsuarioDTO.getContrasena()));
        usuario.setNombreCompleto(crearUsuarioDTO.getNombreCompleto());
        usuario.setEmail(crearUsuarioDTO.getEmail());
        usuario.setFechaCreacion(new Date());
        usuario.setActivo(true);

        Optional<Departamento> departamento = departamentoRepositorio.findById(crearUsuarioDTO.getIdDepartamento());
        departamento.ifPresent(usuario::setDepartamento);

        Optional<Rol> rol = rolRepositorio.findById(crearUsuarioDTO.getIdRol());
        rol.ifPresent(usuario::setRol);

        usuario = usuarioRepositorio.save(usuario);
        return convertirUsuarioADTO(usuario);
    }

    public UsuarioDTO actualizarUsuario(Integer id, ActualizarUsuarioDTO actualizarUsuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombreCompleto(actualizarUsuarioDTO.getNombreCompleto());
            usuario.setNombreUsuario(actualizarUsuarioDTO.getNombreUsuario());
            usuario.setEmail(actualizarUsuarioDTO.getEmail());

            usuario = usuarioRepositorio.save(usuario);
            return convertirUsuarioADTO(usuario);
        } else {
            return null; // O lanzar una excepción
        }
    }
    
    public UsuarioDTO cambiarEstado(Integer id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        usuario.setActivo(!usuario.getActivo());
        usuarioRepositorio.save(usuario);

        // Conversión manual a DTO
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setActivo(usuario.getActivo());

        return usuarioDTO;
    }


    public void eliminarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }

    private UsuarioDTO convertirUsuarioADTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setActivo(usuario.getActivo());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setEmail(usuario.getEmail());

        if (usuario.getDepartamento() != null) {
            EmpresaLiteDTO empresaLiteDTO = usuario.getDepartamento().getEmpresa() != null 
                ? new EmpresaLiteDTO(
                    usuario.getDepartamento().getEmpresa().getIdEmpresa(),
                    usuario.getDepartamento().getEmpresa().getNombreEmpresa()
                ) 
                : null; // Si no hay empresa, ponemos null

            usuarioDTO.setDepartamento(new DepartamentoDTO(
                usuario.getDepartamento().getIdDepartamento(),
                usuario.getDepartamento().getNombreDepartamento(),
                empresaLiteDTO
            ));
        }



        if (usuario.getRol() != null) {
            usuarioDTO.setRol(new RolDTO(usuario.getRol().getIdRol(), usuario.getRol().getNombreRol()));
        }

        return usuarioDTO;
    }



}