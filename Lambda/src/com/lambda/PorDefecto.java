package com.lambda;

public interface PorDefecto {

	void mostrarNombre(String nombre);
	default String nombrePorDefecto(String nombre) {
		return nombre + "Default";
	}
	
	
}
