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

import com.example.tienda.model.Proveedores;
import com.example.tienda.repository.ProveedoresRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	public ProveedoresRepository repository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Proveedores>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Proveedores nuevo) {
		
		return repository.findById(nuevo.getNitproveedor()).map(usuario -> {
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
	public ResponseEntity<?> replace(@RequestBody Proveedores nuevo) {

		return repository.findById(nuevo.getNitproveedor()).map(proveedor -> {
			proveedor.setNitproveedor(nuevo.getNitproveedor());
			proveedor.setCiudad_proveedor(nuevo.getCiudad_proveedor());
			proveedor.setDireccion_proveedor(nuevo.getDireccion_proveedor());
			proveedor.setNombre_proveedor(nuevo.getNombre_proveedor());
			proveedor.setTelefono_proveedor(nuevo.getTelefono_proveedor());
			return ResponseEntity.ok(repository.save(proveedor));
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
