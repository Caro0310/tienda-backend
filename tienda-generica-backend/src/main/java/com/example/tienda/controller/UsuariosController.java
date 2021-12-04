package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.tienda.model.Usuarios;
import com.example.tienda.repository.UsuariosRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosRepository repository;

	@PostMapping("/validar")
	public boolean validar(@RequestBody Usuarios usuario) {
		boolean valido = true; // = serviceUsuario.validarUsuario(p.getUsuario(), p.getClave_Usuario());
		if (valido) {
			return true;
		} else {

			return false;

		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Usuarios>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Usuarios nuevo) {
		
		return repository.findById(nuevo.getCedula_usuario()).map(usuario -> {
			return ResponseEntity.ok(nuevo);
		}).orElseGet(() -> {
			;
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nuevo));
		});
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> replace(@RequestBody Usuarios nuevo) {

		Usuarios actualizado = repository.findById(nuevo.getCedula_usuario()).map(user -> {
			user.setCedula_usuario(nuevo.getCedula_usuario());
			user.setEmail_usuario(nuevo.getEmail_usuario());
			user.setNombre_usuario(nuevo.getNombre_usuario());
			user.setPassword(nuevo.getPassword());
			user.setUsuario(nuevo.getUsuario());
			return repository.save(user);
		}).orElseGet(() -> {
			return repository.save(nuevo);
		});
		return ResponseEntity.ok(actualizado);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
