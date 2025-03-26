package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Caracteristica;

@Repository
public interface CaracteristicaRepositorio extends JpaRepository<Caracteristica, Integer> {
}