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

import com.example.tienda.model.Productos;
import com.example.tienda.repository.ProductosRepository;
import com.example.tienda.repository.ProveedoresRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	public ProductosRepository repository;
	
	@Autowired
	public ProveedoresRepository proveedorRepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Productos>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Productos nuevo) {
		
		if(proveedorRepository.findById(nuevo.getProveedores().getNitproveedor()).isEmpty()){
			return ResponseEntity.badRequest().body("No existe el proveedor");	
		}
		
		return repository.findById(nuevo.getCodigo_producto()).map(usuario -> {
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
	public ResponseEntity<?> replace(@RequestBody Productos nuevo) {
		
		if(proveedorRepository.findById(nuevo.getProveedores().getNitproveedor()).isEmpty()){
			return ResponseEntity.badRequest().body("No existe el proveedor");	
		}
		
		return repository.findById(nuevo.getCodigo_producto())
				.map(producto -> {
					producto.setCodigo_producto(nuevo.getCodigo_producto());
					producto.setIvacompra(nuevo.getIvacompra());
					producto.setNombre_producto(nuevo.getNombre_producto());
					producto.setPrecio_compra(nuevo.getPrecio_compra());
					producto.setPrecio_venta(nuevo.getPrecio_venta());
					producto.setProveedores(nuevo.getProveedores());
					return ResponseEntity.ok(repository.save(producto));
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
