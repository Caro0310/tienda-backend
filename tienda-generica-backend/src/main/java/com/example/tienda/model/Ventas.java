package com.example.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo_venta;
	
	@ManyToOne
	@JoinColumn(name = "cedula_cliente")
	Clientes clientes;
	
	@ManyToOne
	@JoinColumn(name = "cedula_usuario")
	Usuarios usuarios;
	
	@Column(name = "ivaventa")
	Double ivaventa;
	
	@Column(name = "total_venta")
	Double total_venta;
	
	@Column(name = "valor_venta")
	Double valor_venta;
	
	public Ventas() {
		
	}

	public Ventas(Long codigo_venta, Clientes clientes, Usuarios usuarios, Double ivaventa, Double total_venta,
			Double valor_venta) {
		this.codigo_venta = codigo_venta;
		this.clientes = clientes;
		this.usuarios = usuarios;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	

}
