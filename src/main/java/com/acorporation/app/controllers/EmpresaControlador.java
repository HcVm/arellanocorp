package com.acorporation.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorporation.app.dto.EmpresaDTO;
import com.acorporation.app.services.EmpresaServicio;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    @Autowired
    private EmpresaServicio empresaServicio;

    @PostMapping
    public ResponseEntity<EmpresaDTO> crearEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO nuevaEmpresa = empresaServicio.crearEmpresa(empresaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> obtenerTodasLasEmpresas() {
        List<EmpresaDTO> empresas = empresaServicio.obtenerTodasLasEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> obtenerEmpresaPorId(@PathVariable Integer id) {
        EmpresaDTO empresa = empresaServicio.obtenerEmpresaPorId(id);
        return (empresa != null) ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@PathVariable Integer id, @RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO empresaActualizada = empresaServicio.actualizarEmpresa(id, empresaDTO);
        return (empresaActualizada != null) ? ResponseEntity.ok(empresaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Integer id) {
        empresaServicio.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
