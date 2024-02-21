package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
