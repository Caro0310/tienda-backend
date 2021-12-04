package com.example.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
public class Productos {
	
	@Id
	private long codigo_producto;
	
	@Column(name = "ivacompra")
	private double ivacompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "nitproveedor")
	Proveedores proveedores;
	
	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "precio_compra")
	private double precio_compra;
	
	@Column(name = "precio_venta")
	private double precio_venta;
	
	public Productos() {
		
	}

	public Productos(long codigo_producto, double ivacompra, Proveedores proveedores, String nombre_producto,
			double precio_compra, double precio_venta) {
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.proveedores = proveedores;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}


	public long getCodigo_producto() {
		return codigo_producto;
	}


	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}


	public double getIvacompra() {
		return ivacompra;
	}


	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}


	public Proveedores getProveedores() {
		return proveedores;
	}


	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public double getPrecio_compra() {
		return precio_compra;
	}


	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}


	public double getPrecio_venta() {
		return precio_venta;
	}


	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}


}
