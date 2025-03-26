package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.ValorCaracteristica;

@Repository
public interface ValorCaracteristicaRepositorio extends JpaRepository<ValorCaracteristica, Integer> {
}
