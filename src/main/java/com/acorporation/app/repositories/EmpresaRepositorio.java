package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {

}
