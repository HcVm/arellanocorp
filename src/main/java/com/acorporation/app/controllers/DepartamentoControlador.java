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

import com.acorporation.app.dto.DepartamentoDTO;
import com.acorporation.app.services.DepartamentoServicio;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoControlador {

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @PostMapping
    public ResponseEntity<DepartamentoDTO> crearDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        DepartamentoDTO nuevoDepartamento = departamentoServicio.crearDepartamento(departamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDepartamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> obtenerTodosLosDepartamentos() {
        List<DepartamentoDTO> departamentos = departamentoServicio.obtenerTodosLosDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> obtenerDepartamentoPorId(@PathVariable Integer id) {
        DepartamentoDTO departamento = departamentoServicio.obtenerDepartamentoPorId(id);
        return (departamento != null) ? ResponseEntity.ok(departamento) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> actualizarDepartamento(@PathVariable Integer id, @RequestBody DepartamentoDTO departamentoDTO) {
        DepartamentoDTO departamentoActualizado = departamentoServicio.actualizarDepartamento(id, departamentoDTO);
        return (departamentoActualizado != null) ? ResponseEntity.ok(departamentoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Integer id) {
        departamentoServicio.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
