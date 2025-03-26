package com.acorporation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    
    List<Producto> findByCatalogoElectronico_IdCatalogo(Integer idCatalogo);

    List<Producto> findByMarca_IdMarca(Integer idMarca);
    
    List<Producto> findByCatalogoElectronico_IdCatalogoAndMarca_IdMarca(Integer idCatalogo, Integer idMarca);
}
