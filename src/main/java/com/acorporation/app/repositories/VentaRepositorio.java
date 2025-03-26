package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Venta;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
}