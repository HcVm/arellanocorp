package com.acorporation.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	
	@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.departamento LEFT JOIN FETCH u.rol WHERE u.idUsuario = :id")
    Optional<Usuario> findByIdWithRelations(@Param("id") Integer id);

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.departamento LEFT JOIN FETCH u.rol")
    List<Usuario> findAllWithRelations();
	
}