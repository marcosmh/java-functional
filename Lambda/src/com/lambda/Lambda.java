package com.lambda;

public class Lambda implements PorDefecto{

	public static void main(String[] args) {
				
		
		//System.out.println(System.getProperty("java.runtime.version"));
		
		int a = 2;
		int b = 3;
				
				
				MiNombre anonimo = new MiNombre() {
					@Override
					public String miNombre() {
						return "Marcos";
					}
				};
				
				Sumar suma = new Sumar() {
					@Override
					public int sumar(int a, int b) {
						return a +  b;
					}
				};

					
				System.out.println(anonimo.miNombre());
				
				MiNombre nombreL = () -> "Marcos Maga�a";
				
				System.out.println(nombreL.miNombre());
				
				
				System.out.println(suma.sumar(a, b));
				
				Sumar add = (x, z) -> x + z;
				
				System.out.println(add.sumar(a, b));
				
				Sumar sum = (i, j) -> {
					i = i * j;
					i += i + j;
					System.out.println("proceso...");
					return i;
				};
				
				
				System.out.println(sum.sumar(a, b));
				
				
		
				Lambda l = new Lambda();
				System.out.println(l.nombrePorDefecto("Marcos Maga�a "));
		
		
		
	}
	
	

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
	
	

}
