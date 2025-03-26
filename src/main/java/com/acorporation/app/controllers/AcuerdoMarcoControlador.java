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

import com.acorporation.app.dto.AcuerdoMarcoDTO;
import com.acorporation.app.services.AcuerdoMarcoServicio;

@RestController
@RequestMapping("/acuerdos")
public class AcuerdoMarcoControlador {

    @Autowired
    private AcuerdoMarcoServicio acuerdoMarcoServicio;

    @GetMapping
    public ResponseEntity<List<AcuerdoMarcoDTO>> obtenerTodosLosAcuerdos() {
        List<AcuerdoMarcoDTO> acuerdos = acuerdoMarcoServicio.obtenerTodosLosAcuerdosMarco();
        return ResponseEntity.ok(acuerdos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAcuerdoPorId(@PathVariable Integer id) {
        try {
            AcuerdoMarcoDTO acuerdo = acuerdoMarcoServicio.obtenerAcuerdoMarcoPorId(id);
            return ResponseEntity.ok(acuerdo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crearAcuerdo(@RequestBody AcuerdoMarcoDTO acuerdoMarcoDTO) {
        try {
            AcuerdoMarcoDTO nuevoAcuerdo = acuerdoMarcoServicio.crearAcuerdoMarco(acuerdoMarcoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAcuerdo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el acuerdo: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAcuerdo(@PathVariable Integer id, @RequestBody AcuerdoMarcoDTO acuerdoMarcoDTO) {
        try {
            AcuerdoMarcoDTO acuerdoActualizado = acuerdoMarcoServicio.actualizarAcuerdoMarco(id, acuerdoMarcoDTO);
            return ResponseEntity.ok(acuerdoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAcuerdo(@PathVariable Integer id) {
        try {
            acuerdoMarcoServicio.eliminarAcuerdoMarco(id);
            return ResponseEntity.ok("Acuerdo Marco eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
