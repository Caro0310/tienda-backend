package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Clientes;
import com.example.tienda.repository.ClientesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository repository; 
	
	@GetMapping("/listar")
	public ResponseEntity<List<Clientes>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Clientes nuevo) {
		
		return repository.findById(nuevo.getCedula_cliente()).map(usuario -> {
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
	public ResponseEntity<?> replace(@RequestBody Clientes nuevo) {

		return repository.findById(nuevo.getCedula_cliente()).map(cliente -> {
				cliente.setCedula_cliente(nuevo.getCedula_cliente());
				cliente.setEmail_cliente(nuevo.getEmail_cliente());
				cliente.setNombre_cliente(nuevo.getNombre_cliente());
				cliente.setDireccion_cliente(nuevo.getDireccion_cliente());
				cliente.setTelefono_cliente(nuevo.getTelefono_cliente());
			return ResponseEntity.ok(repository.save(cliente));
		}).orElseGet(() -> {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nuevo));
		});

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
