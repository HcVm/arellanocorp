package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Documento;

@Repository
public interface DocumentoRepositorio extends JpaRepository<Documento, Integer> {
}