package com.acorporation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.CatalogoElectronico;

@Repository
public interface CatalogoElectronicoRepositorio extends JpaRepository<CatalogoElectronico, Integer> {
	
	List<CatalogoElectronico> findByAcuerdoMarco_IdAcuerdo(Integer idAcuerdo);
}