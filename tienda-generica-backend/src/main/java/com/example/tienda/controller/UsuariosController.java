package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Usuarios;
import com.example.tienda.repository.UsuariosRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
	
	@Autowired
	private UsuariosRepository usuariosRepository; 
	
	// get all usuarios
	@GetMapping("/usuarios")
	public List<Usuarios> getAllUsuarios(){
		
		return usuariosRepository.findAll();
	}
	
	// REST API
	@PostMapping("/usuarios")
	public Usuarios createUsuario(@RequestBody Usuarios usuario) {
		return usuariosRepository.save(usuario);
	}
}
