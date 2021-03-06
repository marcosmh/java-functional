package com.optional;

import java.util.Optional;

public class OptionalPrueba {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		//probarOptional("");
		//orElseOptional(null);
		//orElseThrow(null);
		isPresent(null);
	}
	
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
		Optional<String> optional  = Optional.empty();
		optional.get();
	}
	
	public static void orElseOptional(String nombre) {
		Optional<String> optional  = Optional.ofNullable(nombre);
		String nombreOfNullable = optional.orElse("x");		
		System.out.println(nombreOfNullable);
	}
	
	public static void orElseThrow(String nombre) {		
		Optional<String> optional  = Optional.ofNullable(nombre);		
		optional.orElseThrow(ArithmeticException::new);				
	}
	
	public static void isPresent(String nombre) {		
		Optional<String> optional  = Optional.ofNullable(nombre);		
		System.out.println(optional.isPresent());
		
	}


}
