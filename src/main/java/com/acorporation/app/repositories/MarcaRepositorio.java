package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Marca;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {

}
