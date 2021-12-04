package com.example.tienda.util;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.example.tienda.model.DetalleVentas;

@JsonComponent
public class DetalleVentasJsonSerializer extends JsonSerializer<DetalleVentas>{
	
	@Override
	public void serialize(DetalleVentas value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		gen.writeNumberField("codigo_detalle_venta", value.getCodigo_detalle_venta());
		gen.writeNumberField("cantidad_producto", value.getCantidad_producto());
		gen.writeNumberField("codigo_producto", value.getProductos().getCodigo_producto());
		gen.writeNumberField("codigo_venta", value.getVentas().getCodigo_venta());
		gen.writeNumberField("valor_total", value.getValor_total());
		gen.writeNumberField("valor_venta", value.getValor_venta());
		gen.writeNumberField("valoriva", value.getValoriva());
		
	}

}
