package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{

}
