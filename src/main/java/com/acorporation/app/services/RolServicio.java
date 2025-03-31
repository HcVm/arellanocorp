package com.acorporation.app.services;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.ActualizarRolDTO;
import com.acorporation.app.dto.CrearRolDTO;
import com.acorporation.app.dto.PermisoDTO;
import com.acorporation.app.dto.RolDTO;
import com.acorporation.app.models.Permiso;
import com.acorporation.app.models.Rol;
import com.acorporation.app.models.RolPermiso;
import com.acorporation.app.repositories.PermisoRepositorio;
import com.acorporation.app.repositories.RolPermisoRepositorio;
import com.acorporation.app.repositories.RolRepositorio;

import jakarta.transaction.Transactional;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PermisoRepositorio permisoRepositorio;

    @Autowired
    private RolPermisoRepositorio rolPermisoRepositorio;

    public List<RolDTO> obtenerTodosLosRoles() {
        List<Rol> roles = rolRepositorio.findAll();
        return roles.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public RolDTO obtenerRolPorId(Integer id) {
        return rolRepositorio.findById(id).map(this::convertirADTO).orElse(null);
    }

    public RolDTO crearRol(CrearRolDTO crearRolDTO) {
        Rol rol = new Rol();
        rol.setNombreRol(crearRolDTO.getNombreRol());
        rol = rolRepositorio.save(rol);

        if (crearRolDTO.getPermisos() != null) {
            for (Integer idPermiso : crearRolDTO.getPermisos()) {
                Permiso permiso = permisoRepositorio.findById(idPermiso).orElse(null);
                if (permiso != null) {
                    RolPermiso rolPermiso = new RolPermiso();
                    rolPermiso.setRol(rol);
                    rolPermiso.setPermiso(permiso);
                    rolPermisoRepositorio.save(rolPermiso);
                }
            }
        }

        return convertirADTO(rol);
    }
    
    @Transactional
    public RolDTO actualizarRol(Integer id, ActualizarRolDTO actualizarRolDTO) {
        Optional<Rol> rolOptional = rolRepositorio.findById(id);

        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();

            rolPermisoRepositorio.deleteByRol(rol);

            if (actualizarRolDTO.getPermisos() != null) {
                List<Permiso> permisos = permisoRepositorio.findAllById(actualizarRolDTO.getPermisos());

                for (Permiso permiso : permisos) {
                    RolPermiso rolPermiso = new RolPermiso();
                    rolPermiso.setRol(rol);
                    rolPermiso.setPermiso(permiso);
                    rolPermisoRepositorio.save(rolPermiso);
                }
            }

            rol = rolRepositorio.save(rol);
            return convertirADTO(rol);
        } else {
            return null;
        }
    }


    public void eliminarRol(Integer id) {
        rolRepositorio.deleteById(id);
    }

    private RolDTO convertirADTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setIdRol(rol.getIdRol());
        dto.setNombreRol(rol.getNombreRol());

        Set<PermisoDTO> permisosDTO = rol.getRolPermisos().stream()
            .map(rp -> {
                PermisoDTO permisoDTO = new PermisoDTO();
                permisoDTO.setIdPermiso(rp.getPermiso().getIdPermiso());
                permisoDTO.setNombrePermiso(rp.getPermiso().getNombrePermiso());
                return permisoDTO;
            })
            .collect(Collectors.toSet());

        dto.setPermisos(permisosDTO);
        return dto;
    }

    
    
}
