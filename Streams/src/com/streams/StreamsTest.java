package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	private static List<User> users;

	public static void main(String[] args) {

		setupUser();
		// Stream stream = Stream.of(users);

		// foreach
		// users.stream().forEach( e -> e.setNombre( e.getNombre() + " X" ) );
		// imprimirLista();

		// map
		/*
		 * List<String> lista = users.stream() .map( e -> e.getNombre() )
		 * .collect(Collectors.toList());
		 * 
		 * lista.stream().forEach(e -> System.out.println(e));
		 */

		// Filters
		/*
		 * List<User> userFilter = users.stream() .filter(e -> e.getNombre() !=
		 * "Marcos") .filter(e -> e.getId() < 3) .collect(Collectors.toList());
		 * userFilter.stream().forEach(e->
		 * System.out.println(e.getId()+" "+e.getNombre()));
		 */

		// FindFirst
		/*
		 * User user = users.stream() .filter(e-> e.getNombre().equals("Marcos"))
		 * .findFirst() .orElse(null); System.out.println( user.getId() + " "
		 * +user.getNombre());
		 */

		// FlatMap
		/*
		 * List<List<String>> nombresVariasLitas = new ArrayList<List<String>> (
		 * Arrays.asList( new ArrayList<String>(Arrays.asList("Marcos","Luis","Fer")),
		 * new ArrayList<String>(Arrays.asList("Juan","Pedro","Kile")) ) );
		 * 
		 * List<String> nombresUnicaLista = nombresVariasLitas.stream()
		 * .flatMap(e->e.stream()).collect(Collectors.toList());
		 * 
		 * nombresUnicaLista.stream().forEach(e-> System.out.println(e));
		 */

		// Peek
		/*
		 * List<User> usersPeek = users.stream() .peek(e-> e.setNombre( e.getNombre() +
		 * " Apellido")) .collect(Collectors.toList());
		 * 
		 * usersPeek.stream().forEach(e->
		 * System.out.println(e.getId()+" "+e.getNombre()));
		 */

		// Count
		long numeroFiltrado = users.stream().filter(e -> e.getId() < 3).count();
		System.out.println("numeroFiltrado: " + numeroFiltrado);

	}

	private static void setupUser() {
		users = new ArrayList<>();
		users.add(new User(1, "Marcos"));
		users.add(new User(2, "Juan"));
		users.add(new User(3, "Carlos"));
		users.add(new User(4, "Mario"));
		users.add(new User(5, "Hector"));

	}

	private static void imprimirLista() {
		users.stream().forEach(e -> System.out.println(e.getId() + " " + e.getNombre()));
	}

	private static void testForEach() {
		// foreach
		System.out.println("use ForEach");
		users.stream().forEach(e -> e.setNombre(e.getNombre() + " X"));
		imprimirLista();
	}

	private static void testMap() {
		System.out.println("use Map");
		List<String> lista = users.stream().map(e -> e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e -> System.out.println(e));

	}

	private static void testFilter() {
		System.out.println("use Filter");
		User user = users.stream().filter(e -> e.getNombre().equals("Marcos")).findFirst().orElse(null);
		System.out.println(user.getId() + " " + user.getNombre());

	}

}