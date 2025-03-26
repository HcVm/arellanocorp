package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Departamento;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
}