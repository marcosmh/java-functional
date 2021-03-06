package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTest {

	private static List<User> users;

	public static void main(String[] args) {

		setupUser();
		// Stream stream = Stream.of(users);

		
		//testForEach();

		//testMap();
		
		//testFilter();
		
		//testFindFirst();
		
		//testFlatMap();
		
		//testPeek();

		//testCount();
		
		//testSkipLimit();
		
		//testSort();
		
		//testMinMax();
		
		//testDistinct();
		
		//testAllMatchAnyMatchNoneMatch();
		
		//testSumAverageRange();
		
		//testReduce();
		
		//testJoining();
		
		//testToSet();
				
		//testSummarizingDouble();
		
		//testPartitionBy();
		
		//testGroupingBy();
		
		//testMapping();
		
		testStreamParalelo();

	}

	private static void setupUser() {
		users = new ArrayList<>();
		users.add(new User(1, "Marcos"));
		users.add(new User(2, "Juan"));
		users.add(new User(3, "Carlos"));
		users.add(new User(4, "Mario"));
		users.add(new User(5, "Hector"));
		users.add(new User(6, "Marcos"));

	}

	private static void imprimirLista() {
		users.stream().forEach(e -> System.out.println(e.getId() + " " + e.getNombre()));
	}

	private static void testForEach() {
		System.out.println("---------  use ForEach --------- ");
		users.stream().forEach(e -> e.setNombre(e.getNombre() + " X"));
		imprimirLista();
	}

	private static void testMap() {
		System.out.println("---------  use Map --------- ");
		List<String> lista = users.stream().map(e -> e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e -> System.out.println(e));

	}

	private static void testFilter() {
		System.out.println(" ---------  use Filter --------- ");
		User user = users.stream().filter(e -> e.getNombre().equals("Marcos")).findFirst().orElse(null);
		System.out.println(user.getId() + " " + user.getNombre());

	}
	
	private static void testFindFirst() {
		System.out.println("---------  use findFirst --------- ");
		  User user = users.stream() .filter(e-> e.getNombre().equals("Marcos"))
		                                             .findFirst() .orElse(null); 
		  System.out.println( user.getId() + " "+user.getNombre());
	}
	
	private static void testFlatMap() {
		System.out.println("---------  use flatMap --------- ");
		List<List<String>> nombresVariasLitas = new ArrayList<List<String>>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Marcos", "Luis", "Fer")),
						new ArrayList<String>(Arrays.asList("Juan", "Pedro", "Kile"))));

		List<String> nombresUnicaLista = nombresVariasLitas.stream().flatMap(e -> e.stream())
				.collect(Collectors.toList());

		nombresUnicaLista.stream().forEach(e -> System.out.println(e));

	}
	
	
	private static void testPeek() {
		System.out.println("---------  use peek --------- ");
		List<User> usersPeek = users.stream().peek(e -> e.setNombre(e.getNombre() + " Apellido"))
				.collect(Collectors.toList());

		usersPeek.stream().forEach(e -> System.out.println(e.getId() + " " + e.getNombre()));

	}
	
	private static void testCount() {
		System.out.println("--------- use count --------- ");
		long numeroFiltrado = users.stream().filter(e -> e.getId() < 3).count();
		System.out.println("numeroFiltrado: " + numeroFiltrado);
	}
	
	
	private static void testSkipLimit() {
		System.out.println("--------- use slkip and limit --------- ");
		String[] abc = {  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"  };
		List<String> abcFilter = Arrays.stream(abc)
				.skip(2)
				.limit(4)
				.collect(Collectors.toList());
		
		abcFilter.stream().forEach(e->System.out.println(e));
	}
	
	private static void testSort() {
		System.out.println("--------- use sort --------- ");
		users = users.stream()
				.sorted(Comparator.comparing(User::getNombre))
				.collect(Collectors.toList());
		imprimirLista();
		
		
	}
	
	private static void testMinMax() {
		System.out.println("--------- use min and max --------- ");
		User userMin = users.stream()
				.min(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println("userMin= " + userMin.getId());
		
		User userMax = users.stream()
				.max(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println("userMax= " + userMax.getId());
		
	}
	
	private static void testDistinct() {
		System.out.println("--------- use distinct --------- ");
		String[] abc = {  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" ,"a" ,"b","c"};
		List<String> abcFilter = Arrays.stream(abc)
				.distinct().collect(Collectors.toList());
		
		abcFilter.stream().forEach(e -> System.out.println(e));
		
	}
	
	private static void testAllMatchAnyMatchNoneMatch() {
		System.out.println("--------- use alMatch - anyMatch - noneMatch --------- ");
		List<Integer> listaNumeros = Arrays.asList(100,300,900,5000);
		
		boolean allMatch = listaNumeros.stream().allMatch(e -> e > 301);
		System.out.println("allMatch= " + allMatch);
		
		boolean anyMatch = listaNumeros.stream().anyMatch(e -> e > 301);
		System.out.println("anyMatch= " + anyMatch);
		
		boolean noneMatch = listaNumeros.stream().noneMatch(e->e>10000);
		System.out.println("noneMatch= " + noneMatch);
				
	}
	
	private static void testSumAverageRange() {
		System.out.println("--------- use sum - average - range --------- ");
		double result = users.stream()
			.mapToInt(User::getId)
			.average()
			.orElse(0);
		System.out.println("average= " + result);
		
		result = users.stream()
				.mapToInt(User::getId)
				.sum();
		System.out.println("sum= " + result);
		
		System.out.println("range= " + IntStream.range(0, 100).sum());
	}
	
	
	private static void testReduce() {
		System.out.println("--------- use reduce --------- ");
		int numero = users.stream()
				.map(User::getId)
				.reduce(100, Integer::sum);
		
		System.out.println("reduce= " + numero);
	}
	
	
	private static void testJoining() {
		System.out.println("--------- use joining --------- ");
		String names = users.stream()
				.map(User::getNombre)
				.collect(Collectors.joining(" - "))
				.toString();
		System.out.println("joining= " + names);
		
	}
	
	private static void testToSet() {
		System.out.println("--------- use toSet --------- ");
		Set<String> setNames = users.stream()
				.map(User::getNombre)
				.collect(Collectors.toSet());
		
		setNames.stream().forEach(e-> System.out.println(e));
	}
	
	private static void testSummarizingDouble() {
		System.out.println("--------- use summarizingDouble --------- ");
		DoubleSummaryStatistics statistics = users.stream()
				.collect(Collectors.summarizingDouble(User::getId));
		
		System.out.println("average=  "+statistics.getAverage()
		+ "  max= " + statistics.getMax() + "  min= " + statistics.getMin()+"  count= "+statistics.getCount() 
		+ "  sum= "+statistics.getSum());
		
		DoubleSummaryStatistics statistics1 = users.stream()
				.mapToDouble(User::getId)
				.summaryStatistics();
		
		System.out.println("average=  "+statistics1.getAverage()
		+ "  max= " + statistics1.getMax() + "  min= " + statistics1.getMin()+"  count= "+statistics1.getCount() 
		+ "  sum= "+statistics1.getSum());
	}
	
	
	private static void testPartitionBy() {
		System.out.println("--------- use partitionBy --------- ");
		List<Integer> numeros = Arrays.asList(5,7,34,56,2,3,67,4,98);
		Map<Boolean, List<Integer>> esMayor = numeros.stream()
				.collect(Collectors.partitioningBy(e-> e >10));
		
		esMayor.get(true).stream().forEach(e-> System.out.println("true= "+e));
		esMayor.get(false).stream().forEach(e-> System.out.println("false= "+e));
		
	}
	
	private static void testGroupingBy() {
		System.out.println("--------- use groupingBy --------- ");
		Map<Character, List<User>> grupoAlfabetico = users.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		
		grupoAlfabetico.get('M').stream().forEach( e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('C').stream().forEach( e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('H').stream().forEach( e -> System.out.println(e.getNombre()));
		
	}
	
	private static void testMapping() {
		System.out.println("--------- use mapping --------- ");
		List<String> personas = users.stream()
				.collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		
		personas.stream().forEach(e-> System.out.println(e));
	}
	
	private static void testStreamParalelo() {
		System.out.println("--------- use streamParalelo --------- ");
		long tiempo1 = System.currentTimeMillis();
		System.out.println("tiempo1= "+tiempo1);
		
		List<String> lista = users.stream().map(e -> e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e -> convertirAMayusculas(e));
		
		long tiempo2 = System.currentTimeMillis();
		System.out.println("tiempo2= "+tiempo2);
		
		System.out.println("x= "+ (tiempo2 - tiempo1));
		
		System.out.println("====================================== ");
		 tiempo1 = System.currentTimeMillis();
		 System.out.println("tiempo1= "+tiempo1);
		 lista.parallelStream().forEach(e -> convertirAMayusculas(e));
		 tiempo2 = System.currentTimeMillis();
		 System.out.println("tiempo2= "+tiempo2);
		 System.out.println("parallelStream= "+ (tiempo2 - tiempo1));
		
		
		
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toString();
	}

}
