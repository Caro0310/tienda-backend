package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Productos;
import com.example.tienda.repository.ProductosRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v4")
public class ProductosController {
	
	@Autowired
	public ProductosRepository productosRepository;
	
	// get all productos
		@GetMapping("/productos")
		public List<Productos> getAllProductos(){
			
			return productosRepository.findAll();
		}
		
		// REST API
		@PostMapping("/productos")
		public Productos createProducto(@RequestBody Productos producto) {
			return productosRepository.save(producto);
		}

}
