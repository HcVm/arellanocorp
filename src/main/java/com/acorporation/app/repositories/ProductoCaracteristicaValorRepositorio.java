package com.acorporation.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorporation.app.models.ProductoCaracteristicaValor;

@Repository
public interface ProductoCaracteristicaValorRepositorio extends JpaRepository<ProductoCaracteristicaValor, Integer> {
	
	List<ProductoCaracteristicaValor> findByProductoIdProducto(Integer idProducto);

}