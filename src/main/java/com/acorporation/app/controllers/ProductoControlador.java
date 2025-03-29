package com.acorporation.app.controllers;

import com.acorporation.app.dto.ProductoDTO;
import com.acorporation.app.services.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = productoServicio.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Integer id) {
        ProductoDTO producto = productoServicio.obtenerProductoPorId(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO nuevoProducto = productoServicio.crearProducto(productoDTO);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/catalogo/{idCatalogo}")
    public List<ProductoDTO> obtenerProductosPorCatalogo(@PathVariable Integer idCatalogo) {
        return productoServicio.obtenerProductosPorCatalogo(idCatalogo);
    }
    
    @GetMapping("/catalogo/{idCatalogo}/marca/{idMarca}")
    public List<ProductoDTO> obtenerProductosPorCatalogoYMarca(@PathVariable Integer idCatalogo, @PathVariable Integer idMarca) {
        return productoServicio.obtenerProductosPorCatalogoYMarca(idCatalogo, idMarca);
    }


    @GetMapping("/marca/{idMarca}")
    public List<ProductoDTO> obtenerProductosPorMarca(@PathVariable Integer idMarca) {
        return productoServicio.obtenerProductosPorMarca(idMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoActualizado = productoServicio.actualizarProducto(id, productoDTO);
        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}/caracteristicas")
    public ResponseEntity<ProductoDTO> agregarCaracteristicasAProducto(
            @PathVariable Integer id,
            @RequestBody List<Integer> idsCaracteristicas) {

        log.info("➡️ Recibiendo petición para agregar características al producto ID: {}", id);
        log.info("📌 Características recibidas: {}", idsCaracteristicas);

        ProductoDTO productoActualizado = productoServicio.agregarCaracteristicasAProducto(id, idsCaracteristicas);

        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    
    @DeleteMapping("/{idProducto}/caracteristicas/{idCaracteristica}")
    public ResponseEntity<ProductoDTO> eliminarCaracteristicaDeProducto(
            @PathVariable Integer idProducto,
            @PathVariable Integer idCaracteristica) {
        
        ProductoDTO productoActualizado = productoServicio.eliminarCaracteristicaDeProducto(idProducto, idCaracteristica);

        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}