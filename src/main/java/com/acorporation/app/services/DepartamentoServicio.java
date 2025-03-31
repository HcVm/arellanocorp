package com.acorporation.app.services;

import com.acorporation.app.dto.DepartamentoDTO;
import com.acorporation.app.dto.EmpresaLiteDTO;
import com.acorporation.app.models.Departamento;
import com.acorporation.app.models.Empresa;
import com.acorporation.app.repositories.DepartamentoRepositorio;
import com.acorporation.app.repositories.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoServicio {

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() {
        return departamentoRepositorio.findAll()
                .stream()
                .map(this::convertirDepartamentoADTO)
                .collect(Collectors.toList());
    }

    public DepartamentoDTO obtenerDepartamentoPorId(Integer id) {
        return departamentoRepositorio.findById(id)
                .map(this::convertirDepartamentoADTO)
                .orElse(null);
    }

    public DepartamentoDTO crearDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento departamento = new Departamento();
        departamento.setNombreDepartamento(departamentoDTO.getNombreDepartamento());

        if (departamentoDTO.getEmpresa() != null) {
            empresaRepositorio.findById(departamentoDTO.getEmpresa().getIdEmpresa())
                    .ifPresent(departamento::setEmpresa);
        }

        departamento = departamentoRepositorio.save(departamento);
        return convertirDepartamentoADTO(departamento);
    }

    public DepartamentoDTO actualizarDepartamento(Integer id, DepartamentoDTO departamentoDTO) {
        return departamentoRepositorio.findById(id).map(departamento -> {
            departamento.setNombreDepartamento(departamentoDTO.getNombreDepartamento());

            if (departamentoDTO.getEmpresa() != null) {
                empresaRepositorio.findById(departamentoDTO.getEmpresa().getIdEmpresa())
                        .ifPresent(departamento::setEmpresa);
            }

            departamentoRepositorio.save(departamento);
            return convertirDepartamentoADTO(departamento);
        }).orElse(null);
    }

    public void eliminarDepartamento(Integer id) {
        departamentoRepositorio.deleteById(id);
    }

    private DepartamentoDTO convertirDepartamentoADTO(Departamento departamento) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setIdDepartamento(departamento.getIdDepartamento());
        dto.setNombreDepartamento(departamento.getNombreDepartamento());
        if (departamento.getEmpresa() != null) {
            dto.setEmpresa(convertirEmpresaALiteDTO(departamento.getEmpresa()));
        }
        return dto;
    }
    
    private EmpresaLiteDTO convertirEmpresaALiteDTO(Empresa empresa) {
        EmpresaLiteDTO dto = new EmpresaLiteDTO();
        dto.setIdEmpresa(empresa.getIdEmpresa());
        dto.setNombreEmpresa(empresa.getNombreEmpresa());
		return dto;

    }


}
