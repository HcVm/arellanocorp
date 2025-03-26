package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.CotizacionProducto;

@Repository
public interface CotizacionProductoRepositorio extends JpaRepository<CotizacionProducto, Integer> {
}