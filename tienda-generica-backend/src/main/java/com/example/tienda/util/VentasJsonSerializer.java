package com.example.tienda.util;


import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.example.tienda.model.Ventas;

@JsonComponent
public class VentasJsonSerializer extends JsonSerializer<Ventas>{

	@Override
	public void serialize(Ventas value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException{

		gen.writeStartObject();
		gen.writeNumberField("codigo_venta", value.getCodigo_venta());
		gen.writeNumberField("cedula_cliente", value.getClientes().getCedula_cliente());
		gen.writeStringField("nombre_cliente", value.getClientes().getNombre_cliente());
		gen.writeNumberField("cedula_usuario", value.getUsuarios().getCedula_usuario());
		gen.writeNumberField("ivaventa", value.getIvaventa());
		gen.writeNumberField("total_venta", value.getTotal_venta());
		gen.writeNumberField("valor_venta", value.getValor_venta());
		gen.writeEndObject();
	}
}
