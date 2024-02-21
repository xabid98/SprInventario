package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Inventario;


@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
	
}
