package com.acorporation.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.EmpresaDTO;
import com.acorporation.app.dto.MarcaDTO;
import com.acorporation.app.models.Empresa;
import com.acorporation.app.models.Marca;
import com.acorporation.app.repositories.EmpresaRepositorio;
import com.acorporation.app.repositories.MarcaRepositorio;

@Service
public class MarcaServicio {

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<MarcaDTO> obtenerTodasLasMarcas() {
        List<Marca> marcas = marcaRepositorio.findAll();
        return marcas.stream().map(this::convertirMarcaADTO).collect(Collectors.toList());
    }

    public MarcaDTO obtenerMarcaPorId(Integer id) {
        Optional<Marca> marca = marcaRepositorio.findById(id);
        return marca.map(this::convertirMarcaADTO).orElse(null);
    }

    public MarcaDTO crearMarca(MarcaDTO marcaDTO) {
        Marca marca = new Marca();
        marca.setNombreMarca(marcaDTO.getNombreMarca());
        marca.setDescripcion(marcaDTO.getDescripcion());

        Optional<Empresa> empresa = empresaRepositorio.findById(marcaDTO.getEmpresa().getIdEmpresa());
        empresa.ifPresent(marca::setEmpresa);

        marca = marcaRepositorio.save(marca);
        return convertirMarcaADTO(marca);
    }

    public MarcaDTO actualizarMarca(Integer id, MarcaDTO marcaDTO) {
        Optional<Marca> marcaOptional = marcaRepositorio.findById(id);
        if (marcaOptional.isPresent()) {
            Marca marca = marcaOptional.get();
            marca.setNombreMarca(marcaDTO.getNombreMarca());
            marca.setDescripcion(marcaDTO.getDescripcion());

            Optional<Empresa> empresa = empresaRepositorio.findById(marcaDTO.getEmpresa().getIdEmpresa());
            empresa.ifPresent(marca::setEmpresa);

            marca = marcaRepositorio.save(marca);
            return convertirMarcaADTO(marca);
        }
        return null; // O lanzar una excepción
    }

    public void eliminarMarca(Integer id) {
        marcaRepositorio.deleteById(id);
    }

    private MarcaDTO convertirMarcaADTO(Marca marca) {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setIdMarca(marca.getIdMarca());
        marcaDTO.setNombreMarca(marca.getNombreMarca());
        marcaDTO.setDescripcion(marca.getDescripcion());

        // Mapear la empresa al DTO
        if (marca.getEmpresa() != null) {
            EmpresaDTO empresaDTO = new EmpresaDTO();
            empresaDTO.setIdEmpresa(marca.getEmpresa().getIdEmpresa());
            empresaDTO.setNombreEmpresa(marca.getEmpresa().getNombreEmpresa());
            marcaDTO.setEmpresa(empresaDTO);
        }

        return marcaDTO;
    }
}
