package com.acorporation.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.PermisoDTO;
import com.acorporation.app.models.Permiso;
import com.acorporation.app.repositories.PermisoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class PermisoServicio {

    @Autowired
    private PermisoRepositorio permisoRepositorio;

    public List<PermisoDTO> obtenerTodosLosPermisos() {
        List<Permiso> permisos = permisoRepositorio.findAll();
        return permisos.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public PermisoDTO obtenerPermisoPorId(Integer id) {
        return permisoRepositorio.findById(id).map(this::convertirADTO).orElse(null);
    }

    public PermisoDTO crearPermiso(PermisoDTO permisoDTO) {
        Permiso permiso = new Permiso();
        permiso.setNombrePermiso(permisoDTO.getNombrePermiso());
        permiso = permisoRepositorio.save(permiso);
        return convertirADTO(permiso);
    }

    @Transactional
    public void eliminarPermiso(Integer id) {
        Permiso permiso = permisoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));

        permiso.getRolPermisos().clear();
        
        permisoRepositorio.delete(permiso);
    }

    private PermisoDTO convertirADTO(Permiso permiso) {
        PermisoDTO dto = new PermisoDTO();
        dto.setIdPermiso(permiso.getIdPermiso());
        dto.setNombrePermiso(permiso.getNombrePermiso());
        return dto;
    }
}
