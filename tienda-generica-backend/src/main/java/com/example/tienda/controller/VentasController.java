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


import com.example.tienda.model.Ventas;
import com.example.tienda.repository.VentasRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private VentasRepository repository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Ventas>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Ventas nuevo) {
		
		return repository.findById(nuevo.getCodigo_venta()).map(usuario -> {
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
	public ResponseEntity<?> replace(@RequestBody Ventas nuevo) {

		return repository.findById(nuevo.getCodigo_venta()).map(venta -> {
			venta.setClientes(nuevo.getClientes());
			venta.setIvaventa(nuevo.getIvaventa());
			venta.setTotal_venta(nuevo.getTotal_venta());
			venta.setUsuarios(nuevo.getUsuarios());
			venta.setValor_venta(nuevo.getValor_venta());
			return ResponseEntity.ok(repository.save(venta));
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
