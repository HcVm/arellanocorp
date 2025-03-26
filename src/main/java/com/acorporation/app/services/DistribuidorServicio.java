package com.acorporation.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.DistribuidorDTO;
import com.acorporation.app.models.Distribuidor;
import com.acorporation.app.repositories.DistribuidorRepositorio;

@Service
public class DistribuidorServicio {

    @Autowired
    private DistribuidorRepositorio distribuidorRepositorio;

    public List<DistribuidorDTO> obtenerTodosLosDistribuidores() {
        List<Distribuidor> distribuidores = distribuidorRepositorio.findAll();
        return distribuidores.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public DistribuidorDTO obtenerDistribuidorPorId(Integer id) {
        Optional<Distribuidor> distribuidor = distribuidorRepositorio.findById(id);
        return distribuidor.map(this::convertirADTO).orElse(null);
    }

    public DistribuidorDTO crearDistribuidor(DistribuidorDTO distribuidorDTO) {
        Distribuidor distribuidor = convertirAEntidad(distribuidorDTO);
        distribuidor.setFechaCreacion(new Date()); // Asignar fecha de creación
        distribuidor = distribuidorRepositorio.save(distribuidor);
        return convertirADTO(distribuidor);
    }

    public DistribuidorDTO actualizarDistribuidor(Integer id, DistribuidorDTO distribuidorDTO) {
        Optional<Distribuidor> distribuidorOptional = distribuidorRepositorio.findById(id);
        if (distribuidorOptional.isPresent()) {
            Distribuidor distribuidor = distribuidorOptional.get();
            distribuidor.setRuc(distribuidorDTO.getRuc());
            distribuidor.setRazonSocial(distribuidorDTO.getRazonSocial());
            distribuidor.setDireccion(distribuidorDTO.getDireccion());
            distribuidor.setCelular(distribuidorDTO.getCelular());
            distribuidor.setCorreo(distribuidorDTO.getCorreo());
            distribuidor.setContacto(distribuidorDTO.getContacto());
            distribuidor.setObservaciones(distribuidorDTO.getObservaciones());
            distribuidor.setActivo(distribuidorDTO.getActivo());

            distribuidor = distribuidorRepositorio.save(distribuidor);
            return convertirADTO(distribuidor);
        } else {
            return null; // O lanzar una excepción
        }
    }

    public void eliminarDistribuidor(Integer id) {
        distribuidorRepositorio.deleteById(id);
    }

    private DistribuidorDTO convertirADTO(Distribuidor distribuidor) {
        DistribuidorDTO dto = new DistribuidorDTO();
        dto.setIdDistribuidor(distribuidor.getIdDistribuidor());
        dto.setRuc(distribuidor.getRuc());
        dto.setRazonSocial(distribuidor.getRazonSocial());
        dto.setDireccion(distribuidor.getDireccion());
        dto.setCelular(distribuidor.getCelular());
        dto.setCorreo(distribuidor.getCorreo());
        dto.setContacto(distribuidor.getContacto());
        dto.setObservaciones(distribuidor.getObservaciones());
        dto.setFechaCreacion(distribuidor.getFechaCreacion());
        dto.setActivo(distribuidor.getActivo());
        return dto;
    }

    private Distribuidor convertirAEntidad(DistribuidorDTO dto) {
        Distribuidor distribuidor = new Distribuidor();
        distribuidor.setIdDistribuidor(dto.getIdDistribuidor());
        distribuidor.setRuc(dto.getRuc());
        distribuidor.setRazonSocial(dto.getRazonSocial());
        distribuidor.setDireccion(dto.getDireccion());
        distribuidor.setCelular(dto.getCelular());
        distribuidor.setCorreo(dto.getCorreo());
        distribuidor.setContacto(dto.getContacto());
        distribuidor.setObservaciones(dto.getObservaciones());
        distribuidor.setFechaCreacion(dto.getFechaCreacion());
        distribuidor.setActivo(dto.getActivo());
        return distribuidor;
    }
}
