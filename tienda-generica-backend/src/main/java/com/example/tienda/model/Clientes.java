package com.example.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cedula_cliente;
	
	@Column(name = "direccion_cliente")
	private String direccion_cliente;
	
	@Column(name = "email_cliente")
	private String email_cliente;
	
	@Column(name = "nombre_cliente")
	private String nombre_cliente;
	
	@Column(name = "telefono_cliente")
	private String telefono_cliente;
	
	public Clientes() {
		
	}

	public Clientes(String direccion_cliente, String email_cliente, String nombre_cliente, String telefono_cliente) {
		super();
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.nombre_cliente = nombre_cliente;
		this.telefono_cliente = telefono_cliente;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliemte) {
		this.cedula_cliente = cedula_cliemte;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	

}
