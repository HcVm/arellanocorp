package com.acorporation.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorporation.app.dto.DepartamentoDTO;
import com.acorporation.app.dto.EmpresaDTO;
import com.acorporation.app.models.Empresa;
import com.acorporation.app.repositories.EmpresaRepositorio;

@Service
public class EmpresaServicio {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<EmpresaDTO> obtenerTodasLasEmpresas() {
        List<Empresa> empresas = empresaRepositorio.findAll();
        return empresas.stream().map(this::convertirEmpresaADTO).collect(Collectors.toList());
    }

    public EmpresaDTO obtenerEmpresaPorId(Integer id) {
        Optional<Empresa> empresa = empresaRepositorio.findById(id);
        return empresa.map(this::convertirEmpresaADTO).orElse(null);
    }

    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
        empresa.setRuc(empresaDTO.getRuc());
        empresa.setDireccion(empresaDTO.getDireccion());
        empresa.setTelefono(empresaDTO.getTelefono());
        empresa.setEmail(empresaDTO.getEmail());
        empresa.setFechaCreacion(new Date());
        empresa.setActivo(empresaDTO.getActivo());

        empresa = empresaRepositorio.save(empresa);
        return convertirEmpresaADTO(empresa);
    }

    public EmpresaDTO actualizarEmpresa(Integer id, EmpresaDTO empresaDTO) {
        Optional<Empresa> empresaOptional = empresaRepositorio.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
            empresa.setRuc(empresaDTO.getRuc());
            empresa.setDireccion(empresaDTO.getDireccion());
            empresa.setTelefono(empresaDTO.getTelefono());
            empresa.setEmail(empresaDTO.getEmail());
            empresa.setActivo(empresaDTO.getActivo());

            empresa = empresaRepositorio.save(empresa);
            return convertirEmpresaADTO(empresa);
        }
        return null;
    }

    public void eliminarEmpresa(Integer id) {
        empresaRepositorio.deleteById(id);
    }

    private EmpresaDTO convertirEmpresaADTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setIdEmpresa(empresa.getIdEmpresa());
        empresaDTO.setNombreEmpresa(empresa.getNombreEmpresa());
        empresaDTO.setRuc(empresa.getRuc());
        empresaDTO.setDireccion(empresa.getDireccion());
        empresaDTO.setTelefono(empresa.getTelefono());
        empresaDTO.setEmail(empresa.getEmail());
        empresaDTO.setFechaCreacion(empresa.getFechaCreacion());
        empresaDTO.setActivo(empresa.getActivo());

        if (empresa.getDepartamentos() != null) {
            List<DepartamentoDTO> departamentos = empresa.getDepartamentos().stream()
                .map(dep -> new DepartamentoDTO(dep.getIdDepartamento(), dep.getNombreDepartamento()))
                .collect(Collectors.toList());
            empresaDTO.setDepartamentos(departamentos);
        }

        return empresaDTO;
    }
}
