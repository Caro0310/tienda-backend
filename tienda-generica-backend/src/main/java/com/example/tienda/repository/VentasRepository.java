package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas , Long>{

}
