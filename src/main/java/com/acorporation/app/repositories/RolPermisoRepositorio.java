package com.acorporation.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Rol;
import com.acorporation.app.models.RolPermiso;

import jakarta.transaction.Transactional;

@Repository
public interface RolPermisoRepositorio extends JpaRepository<RolPermiso, Integer> {

	@Modifying
	@Transactional
	@Query("DELETE FROM RolPermiso rp WHERE rp.rol = :rol")
	void deleteByRol(@Param("rol") Rol rol);

}