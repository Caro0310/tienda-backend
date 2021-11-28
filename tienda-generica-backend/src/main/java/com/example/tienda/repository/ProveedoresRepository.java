package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Proveedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Long>{

}
