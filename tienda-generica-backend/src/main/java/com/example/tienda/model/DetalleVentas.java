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
@Table(name= "detalle_ventas")
public class DetalleVentas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo_detalle_venta;
	
	Integer cantidad_producto;
	
	@ManyToOne
	@JoinColumn(name = "codigo_producto")
	Productos productos;
	
	@ManyToOne
	@JoinColumn(name = "codigo_venta")
	Ventas ventas;
	
	@Column(name = "valor_total")
	Double valor_total;
	

	@Column(name = "valor_venta")
	Double valor_venta;
	

	@Column(name = "valoriva")
	Double valoriva;
	
	public DetalleVentas() {
		
	}

	public DetalleVentas(Long codigo_detalle_venta, Integer cantidad_producto, Productos productos, Ventas ventas,
			Double valor_total, Double valor_venta, Double valoriva) {
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.productos = productos;
		this.ventas = ventas;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}

	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public Integer getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Double getValoriva() {
		return valoriva;
	}

	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}
	

}
