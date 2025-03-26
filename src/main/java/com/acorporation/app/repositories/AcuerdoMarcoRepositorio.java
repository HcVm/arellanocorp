package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.AcuerdoMarco;

@Repository
public interface AcuerdoMarcoRepositorio extends JpaRepository<AcuerdoMarco, Integer> {
}