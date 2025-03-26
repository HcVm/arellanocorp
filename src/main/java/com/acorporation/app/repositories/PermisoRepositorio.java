package com.acorporation.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Permiso;

@Repository
public interface PermisoRepositorio extends JpaRepository<Permiso, Integer> {

	Optional<Permiso> findById(Integer id);
}