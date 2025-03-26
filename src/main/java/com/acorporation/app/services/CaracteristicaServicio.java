package com.acorporation.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.CaracteristicaDTO;
import com.acorporation.app.dto.ValorCaracteristicaDTO;
import com.acorporation.app.models.Caracteristica;
import com.acorporation.app.models.ValorCaracteristica;
import com.acorporation.app.repositories.CaracteristicaRepositorio;

@Service
public class CaracteristicaServicio {

    @Autowired
    private CaracteristicaRepositorio caracteristicaRepositorio;

    public List<CaracteristicaDTO> obtenerTodasLasCaracteristicas() {
        List<Caracteristica> caracteristicas = caracteristicaRepositorio.findAll();
        return caracteristicas.stream().map(this::convertirCaracteristicaADTO).collect(Collectors.toList());
    }

    public CaracteristicaDTO obtenerCaracteristicaPorId(Integer id) {
        Optional<Caracteristica> caracteristica = caracteristicaRepositorio.findById(id);
        return caracteristica.map(this::convertirCaracteristicaADTO).orElse(null);
    }

    public CaracteristicaDTO crearCaracteristica(CaracteristicaDTO caracteristicaDTO) {
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setNombreCaracteristica(caracteristicaDTO.getNombreCaracteristica());

        caracteristica = caracteristicaRepositorio.save(caracteristica);
        return convertirCaracteristicaADTO(caracteristica);
    }

    public CaracteristicaDTO actualizarCaracteristica(Integer id, CaracteristicaDTO caracteristicaDTO) {
        Optional<Caracteristica> caracteristicaOptional = caracteristicaRepositorio.findById(id);
        if (caracteristicaOptional.isPresent()) {
            Caracteristica caracteristica = caracteristicaOptional.get();
            caracteristica.setNombreCaracteristica(caracteristicaDTO.getNombreCaracteristica());

            caracteristica = caracteristicaRepositorio.save(caracteristica);
            return convertirCaracteristicaADTO(caracteristica);
        }
        return null;
    }

    public void eliminarCaracteristica(Integer id) {
        caracteristicaRepositorio.deleteById(id);
    }

    private CaracteristicaDTO convertirCaracteristicaADTO(Caracteristica caracteristica) {
        CaracteristicaDTO dto = new CaracteristicaDTO();
        dto.setIdCaracteristica(caracteristica.getIdCaracteristica());
        dto.setNombreCaracteristica(caracteristica.getNombreCaracteristica());

        // Convertir la lista de valores
        List<ValorCaracteristicaDTO> valoresDTO = caracteristica.getValores().stream()
                .map(this::convertirValorADTO)
                .collect(Collectors.toList());
        dto.setValores(valoresDTO);

        return dto;
    }


    private ValorCaracteristicaDTO convertirValorADTO(ValorCaracteristica valor) {
        ValorCaracteristicaDTO dto = new ValorCaracteristicaDTO();
        dto.setIdValorCaracteristica(valor.getIdValorCaracteristica());
        dto.setValor(valor.getValor());
        return dto;
    }

}
