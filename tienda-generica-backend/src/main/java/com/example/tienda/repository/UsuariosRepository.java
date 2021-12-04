package com.example.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	
	//Optional<Usuarios> findByUsuario(String usuario);
	//Optional<Usuarios> findByCorreo(String email_usuario);
}
