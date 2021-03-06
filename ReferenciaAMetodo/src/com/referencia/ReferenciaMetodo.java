package com.referencia;

import java.util.ArrayList;
import java.util.List;

public class ReferenciaMetodo {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		/*
		 * Referencia a       Class::staticMethod     Math:abs      n -> Math.abs(n)
		 * static method
		 */
		
		Trabajo trabajo = new Trabajo() {
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
			}
		};
		
		trabajo.accion();
		
		Trabajo trabajoL = () -> User.referenciaAMetodoEstatico();
		trabajoL.accion();
		
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		trabajoMR.accion();
		
		System.out.println("--------------------------------------------------------------------------");
		
		/*
		 * Referencia a un         instancia::metodoInstancia  s:toString   () -> "string".toString 
		 * metodo de instancia
		 * de un objeto
		 * particular
		 */
		
		
		User user = new User("Marcos");
		Trabajo trabajo2 = () -> user.referenciaAMetodoParticular();
		trabajo2.accion();
		Trabajo trabajo2MR = user::referenciaAMetodoParticular;
		trabajo2MR.accion();
		
		
		System.out.println("--------------------------------------------------------------------------");
		
		/*
		 * Referencia a un              Class:metodoInstancia    String::toString    s -> s.toString()
		 * metodo de instancia
		 * de un objeto
		 * arbitrario de 
		 * un tipo particular
		 */
		
		TrabajoString trabajoString = (cadena) -> cadena.toUpperCase();
		System.out.println(trabajoString.accion("Marcos+++"));
		TrabajoString trabajoStringRM = String::toUpperCase;
		System.out.println(trabajoStringRM.accion("Marcos...."));
		
		List<User> users = new ArrayList<>();
		users.add(new User("Marcos"));
		users.add(new User("Juan"));
		users.add(new User("Pedro"));
		users.add(new User("Lauro"));
		
		System.out.println("-----");
		users.forEach(nombre -> nombre.mostrarNombre());
		System.out.println("-----");
		users.forEach(User::mostrarNombre);
		
		System.out.println("--------------------------------------------------------------------------");
		
		/*
		 * Referencia a un    Class::new       String::new      () -> new String 
		 * constructor
		 */
		
		IUser user3 = new IUser() {
			@Override
			public User crear(String nombre) {
				return new User(nombre);
			}
		};
		
		user3.crear("Mark").mostrarNombre();
		
		IUser userL = (nombre -> new User(nombre));
		userL.crear("Mark I").mostrarNombre();
		IUser userMR = User::new;
		userMR.crear("Mark II").mostrarNombre();
		
	}

}
