package com.acorporation.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
	
	Optional<Rol> findByNombreRol(String nombreRol);
}