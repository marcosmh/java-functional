package com.highorderfunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HighOrderFunctions implements SumarInterfaz {

	

	public static void main(String[] args) {
		HighOrderFunctions hof = new HighOrderFunctions();

		System.out.println(hof.suma(2,3));
		System.out.println(hof.apply(2,4));
		
		SumarInterfaz sumarInterfaz = new SumarInterfaz() {
			@Override
			public int apply(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println("x= "+hof.sumaHighOrderFunctions(sumarInterfaz, 2, 5));
		
		SumarInterfaz sumarInterfaz2 = (a,b) -> a+b;
		System.out.println("z= "+hof.sumaHighOrderFunctions(sumarInterfaz2, 2, 6));
		
		System.out.println("==============Interfaz funcional =================== ");
		/*
		Interface Function<T t, R t>
		{
			R apply(T,t)
		}
		*/
		Function<String, String> convertirAMayusculas = e -> e.toUpperCase();
		hof.imprimirMayusculas(convertirAMayusculas, "marcos");
		
		System.out.println("==============Interfaz funcional BiFunction<T, U, R> =================== ");		
		/*
		interface BiFunction<T,U,R>
		{
			R apply (T t, U u)
		}
		*/
		/*
		interface Predicate<T>
		{
			Boolean text (T, t)
		}
		*/
		List<Integer> numeros = Arrays.asList(6,23,-5,4,68,-9,-67,46);
		BiFunction<
			List<Integer>,
			Predicate<Integer>,
			List<Integer>
		> filtrar;
		
		filtrar = (lista, predicado) -> lista.stream()
				.filter(e -> predicado.test(e))
				.collect(Collectors.toList());
		
		System.out.println(filtrar.apply(numeros, e -> e > 0));
		
		
		System.out.println("==============Interfaz funcional Consumer<T> =================== ");
		/*
		interface Consumer<T>
		{
			void accept(T t)
		}
		*/
		List<String> nombres = new ArrayList<>();
		nombres.add("Marcos");
		nombres.add("Angel");
		nombres.add("Angie");
		nombres.add("Lau");
		
		hof.filtrar(nombres, e-> System.out.println(e), 6 );
		
		
	}
	
	
	public int suma(int a, int b) {
		return a + b;
	}


	@Override
	public int apply(int a, int b) {
		return a + b;
	}
	
	
	public int sumaHighOrderFunctions(SumarInterfaz sumar, int a, int b) {
		System.out.println("----- HighOrderFunctions --- ");
		return sumar.apply(a, b);
	}
	
	public void imprimirMayusculas(Function<String, String> function, String nombre) {
		System.out.println(function.apply(nombre));
	}
	
	
	public void filtrar(List<String> lista, Consumer<String> consumer, int maxCaracteres) {
		lista.stream().filter(logicaPredicado(maxCaracteres)).forEach(consumer);
	}
	
	public Predicate<String> logicaPredicado(int maxCaracteres) {
		return e -> e.length() < maxCaracteres;
	}

}
