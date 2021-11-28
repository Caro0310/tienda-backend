package com.example.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes , Long>{

}
