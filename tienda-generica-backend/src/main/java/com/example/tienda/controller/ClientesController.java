package com.example.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Clientes;
import com.example.tienda.repository.ClientesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v22")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository; 
	
	// get all clientes
	@GetMapping("/clientes")
	public List<Clientes> getAllClientes(){
		
		return clientesRepository.findAll();
	}
	
	// REST API
		@PostMapping("/clientes")
		public Clientes createCliente(@RequestBody Clientes cliente) {
			return clientesRepository.save(cliente);
	
		}

}
