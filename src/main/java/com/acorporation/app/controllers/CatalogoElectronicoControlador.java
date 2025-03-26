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

import com.acorporation.app.dto.CatalogoElectronicoDTO;
import com.acorporation.app.services.CatalogoElectronicoServicio;

@RestController
@RequestMapping("/catalogos")
public class CatalogoElectronicoControlador {

    @Autowired
    private CatalogoElectronicoServicio catalogoElectronicoServicio;

    @GetMapping
    public ResponseEntity<List<CatalogoElectronicoDTO>> obtenerTodosLosCatalogos() {
        List<CatalogoElectronicoDTO> catalogos = catalogoElectronicoServicio.obtenerTodosLosCatalogosElectronicos();
        return ResponseEntity.ok(catalogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoElectronicoDTO> obtenerCatalogoPorId(@PathVariable Integer id) {
        CatalogoElectronicoDTO catalogo = catalogoElectronicoServicio.obtenerCatalogoElectronicoPorId(id);
        return catalogo != null ? ResponseEntity.ok(catalogo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CatalogoElectronicoDTO> crearCatalogo(@RequestBody CatalogoElectronicoDTO catalogoDTO) {
        CatalogoElectronicoDTO nuevoCatalogo = catalogoElectronicoServicio.crearCatalogoElectronico(catalogoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCatalogo);
    }
    
    @GetMapping("/acuerdo/{idAcuerdo}")
    public ResponseEntity<List<CatalogoElectronicoDTO>> obtenerCatalogosPorAcuerdo(@PathVariable Integer idAcuerdo) {
        List<CatalogoElectronicoDTO> catalogos = catalogoElectronicoServicio.obtenerCatalogosPorAcuerdo(idAcuerdo);
        return ResponseEntity.ok(catalogos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogoElectronicoDTO> actualizarCatalogo(
            @PathVariable Integer id, @RequestBody CatalogoElectronicoDTO catalogoDTO) {
        CatalogoElectronicoDTO catalogoActualizado = catalogoElectronicoServicio.actualizarCatalogoElectronico(id, catalogoDTO);
        return catalogoActualizado != null ? ResponseEntity.ok(catalogoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCatalogo(@PathVariable Integer id) {
        catalogoElectronicoServicio.eliminarCatalogoElectronico(id);
        return ResponseEntity.noContent().build();
    }
}
