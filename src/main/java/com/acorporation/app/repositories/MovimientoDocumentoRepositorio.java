package com.acorporation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.MovimientoDocumento;

@Repository
public interface MovimientoDocumentoRepositorio extends JpaRepository<MovimientoDocumento, Integer> {
	
	List<MovimientoDocumento> findByDocumentoIdDocumento(Integer idDocumento);
}
