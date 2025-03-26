package com.acorporation.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.ValorCaracteristicaDTO;
import com.acorporation.app.models.Caracteristica;
import com.acorporation.app.models.ValorCaracteristica;
import com.acorporation.app.repositories.CaracteristicaRepositorio;
import com.acorporation.app.repositories.ValorCaracteristicaRepositorio;

@Service
public class ValorCaracteristicaServicio {

    @Autowired
    private ValorCaracteristicaRepositorio valorCaracteristicaRepositorio;

    @Autowired
    private CaracteristicaRepositorio caracteristicaRepositorio;

    public List<ValorCaracteristicaDTO> obtenerTodosLosValores() {
        List<ValorCaracteristica> valores = valorCaracteristicaRepositorio.findAll();
        return valores.stream().map(this::convertirValorADTO).collect(Collectors.toList());
    }

    public ValorCaracteristicaDTO obtenerValorPorId(Integer id) {
        Optional<ValorCaracteristica> valor = valorCaracteristicaRepositorio.findById(id);
        return valor.map(this::convertirValorADTO).orElse(null);
    }

    public ValorCaracteristicaDTO crearValorCaracteristica(ValorCaracteristicaDTO valorCaracteristicaDTO) {
        ValorCaracteristica valorCaracteristica = new ValorCaracteristica();
        valorCaracteristica.setValor(valorCaracteristicaDTO.getValor());

        Optional<Caracteristica> caracteristica = caracteristicaRepositorio.findById(valorCaracteristicaDTO.getIdCaracteristica());
        caracteristica.ifPresent(valorCaracteristica::setCaracteristica);

        valorCaracteristica = valorCaracteristicaRepositorio.save(valorCaracteristica);
        return convertirValorADTO(valorCaracteristica);
    }

    public ValorCaracteristicaDTO actualizarValorCaracteristica(Integer id, ValorCaracteristicaDTO valorCaracteristicaDTO) {
        Optional<ValorCaracteristica> valorOptional = valorCaracteristicaRepositorio.findById(id);
        if (valorOptional.isPresent()) {
            ValorCaracteristica valorCaracteristica = valorOptional.get();
            valorCaracteristica.setValor(valorCaracteristicaDTO.getValor());

            Optional<Caracteristica> caracteristica = caracteristicaRepositorio.findById(valorCaracteristicaDTO.getIdCaracteristica());
            caracteristica.ifPresent(valorCaracteristica::setCaracteristica);

            valorCaracteristica = valorCaracteristicaRepositorio.save(valorCaracteristica);
            return convertirValorADTO(valorCaracteristica);
        }
        return null;
    }

    public void eliminarValorCaracteristica(Integer id) {
        valorCaracteristicaRepositorio.deleteById(id);
    }

    private ValorCaracteristicaDTO convertirValorADTO(ValorCaracteristica valorCaracteristica) {
        ValorCaracteristicaDTO dto = new ValorCaracteristicaDTO();
        dto.setIdValorCaracteristica(valorCaracteristica.getIdValorCaracteristica());
        dto.setValor(valorCaracteristica.getValor());

        if (valorCaracteristica.getCaracteristica() != null) {
            dto.setIdCaracteristica(valorCaracteristica.getCaracteristica().getIdCaracteristica());
            dto.setNombreCaracteristica(valorCaracteristica.getCaracteristica().getNombreCaracteristica());
        }

        return dto;
    }
}
