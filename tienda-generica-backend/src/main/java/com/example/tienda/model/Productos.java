package com.example.tienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo_producto;
	
	@Column(name = "ivacompra")
	private double ivacompra;
	
	@Column(name = "proveedores_nitproveedor")
	private long proveedores_nitproveedor;
	
	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "precio_compra")
	private double precio_compra;
	
	@Column(name = "precio_venta")
	private double precio_venta;
	
	public Productos() {
		
	}

	public Productos(double ivacompra, long proveedores_nitproveedor, String nombre_producto, double precio_compra,
			double precio_venta) {
		super();
		this.ivacompra = ivacompra;
		this.proveedores_nitproveedor = proveedores_nitproveedor;
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

	public long getProveedores_nitproveedor() {
		return proveedores_nitproveedor;
	}

	public void setProveedores_nitproveedor(long proveedores_nitproveedor) {
		this.proveedores_nitproveedor = proveedores_nitproveedor;
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
