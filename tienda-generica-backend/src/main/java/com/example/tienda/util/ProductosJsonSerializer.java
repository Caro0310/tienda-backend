package com.example.tienda.util;


import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.example.tienda.model.*;

@JsonComponent
public class ProductosJsonSerializer extends JsonSerializer<Productos>{
	
	@Override
	public void serialize(Productos value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException, JsonProcessingException {
		
		gen.writeStartObject();
		gen.writeNumberField("codigo_producto", value.getCodigo_producto());
		gen.writeNumberField("ivacompra", value.getIvacompra());
		gen.writeNumberField("nitproveedor", value.getProveedores().getNitproveedor());
		gen.writeStringField("nombre_producto", value.getNombre_producto());
		gen.writeNumberField("precio_compra", value.getPrecio_compra());
		gen.writeNumberField("precio_venta", value.getPrecio_venta());
		gen.writeEndObject();
			
		}

}
