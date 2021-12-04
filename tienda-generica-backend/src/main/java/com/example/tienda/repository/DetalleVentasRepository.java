package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.DetalleVentas;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas , Long>{

}
