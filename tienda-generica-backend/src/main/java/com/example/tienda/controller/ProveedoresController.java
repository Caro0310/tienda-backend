package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Proveedores;
import com.example.tienda.repository.ProveedoresRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v3")
public class ProveedoresController {
	
	@Autowired
	public ProveedoresRepository proveedoresRepository;
	
	// get all proveedores
	@GetMapping("/proveedores")
	public List<Proveedores> getAllProveedores(){
			
		return proveedoresRepository.findAll();
	}
	
	// REST API
		@PostMapping("/proveedores")
		public Proveedores createProveedor(@RequestBody Proveedores proveedor) {
			return proveedoresRepository.save(proveedor);
		}

}
