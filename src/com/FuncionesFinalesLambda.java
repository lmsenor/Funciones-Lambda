package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FuncionesFinalesLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FuncionesFinalesLambda funciones=new FuncionesFinalesLambda();
		
		funciones.count();
		funciones.forEach();
		funciones.anyMatch();
		funciones.allMatch();
		funciones.noneMatch();
		funciones.max();
		funciones.min();
		funciones.findFirst();
		funciones.toArray();
		funciones.collect();
		funciones.removeIf();
		funciones.paths_readAllLines();
		funciones.paths_lines();
	}
	
	public void count() {
	/////////////////////////////////////////		COUNT	////////////////////////////
		//	Devuelve el número de elementos de un Stream
		System.out.println("\n*************************************************************");
		System.out.println("método .count()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		System.out.println(st.filter(s->s%2==0).count());	//Devuelve el número de números pares
	}
	
	public void forEach() {
	/////////////////////////////////////////		FOREACH		////////////////////////////
		//	Realiza una acción para cada elemento
		System.out.println("\n*************************************************************");
		System.out.println("método .forEach()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		st.forEach(n->System.out.println(n));
	}
	
	public void anyMatch() {
	/////////////////////////////////////////		ANYMATCH	////////////////////////////
		//	Devuelve true si uno de los elementos cumple con la condición del predicado
		System.out.println("\n*************************************************************");
		System.out.println("método .anyMatch()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		System.out.println("alguno mayor 5?: " +st.anyMatch(n->n>5));
	}
	
	public void allMatch() {
	/////////////////////////////////////////		ALLMATCH	////////////////////////////
		//	Devuelve true si todos los elementos cumplen con la condición del predicado
		System.out.println("\n*************************************************************");
		System.out.println("método .allMatch()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		System.out.println("todos mayor 5?: " +st.allMatch(n->n>5));
	}
	
	public void noneMatch() {
	/////////////////////////////////////////		NONEMATCH	////////////////////////////
		//	Devuelve true si ninguno de los elementos cumple con la condición del predicado
		System.out.println("\n*************************************************************");
		System.out.println("método .noneMatch()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		System.out.println("ninguno mayor 5?: " +st.noneMatch(n->n>5));
	}
	
	public void max() {
	/////////////////////////////////////////		MAX		////////////////////////////
		//	Criterio de comparación, si compare() es positivo entonces a>b, si es negativo a<b
		System.out.println("\n*************************************************************");
		System.out.println("método .max()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Optional<Integer> op=st.max((a,b)->a-b);
		System.out.println(op.get());
	}
	
	public void min() {
	/////////////////////////////////////////		MIN		////////////////////////////
		//	Criterio de comparación, si compare() es positivo entonces a<b, si es negativo a>b
		System.out.println("\n*************************************************************");
		System.out.println("método .min()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Optional<Integer> op=st.min((a,b)->a-b);
		System.out.println(op.get());
	}
	
	public void findFirst() {
	/////////////////////////////////////////		FINDFIRST		////////////////////////////
		//	Devuelve el primer elemento del Stream que cumpla la condición, o un Optional vacío si no hay nada
		System.out.println("\n*************************************************************");
		System.out.println("método .findFirst()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Optional<Integer> op=st.filter(s->s%3==0).findFirst();
		System.out.println(op.get());
	}
	
	public void toArray() {
	/////////////////////////////////////////		TOARRAY		////////////////////////////
		//	Convierte el Stream en un Array
		System.out.println("\n*************************************************************");
		System.out.println("método .toArray()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Integer[] res=st.toArray(t->new Integer[t]);

		for(Integer con:res){
			System.out.print(con);
		}
	}
	
	public void collect() {
	/////////////////////////////////////////		COLLECT		////////////////////////////
		//	Devuelve un List con los datos del Stream, también un Map (.toMap()) o Set (.toSet())
		System.out.println("\n*************************************************************");
		System.out.println("método .collect()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		List<Integer> lista=st.distinct().collect(Collectors.toList());
		lista.forEach(n->System.out.print(n));
	}
	

	public void removeIf() {
	/////////////////////////////////////////		REMOVEIF		////////////////////////////
		//	MÉTODOS EN COLECCIONES: elimina un elemento de la lista si se cumple el método .test()
		System.out.println("\n*************************************************************");
		System.out.println("método .removeIf()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		List<Integer> lista=st.distinct().collect(Collectors.toList());
		
		lista.removeIf(n->n>5);
		lista.forEach(n->System.out.print(n));
	}
	
	public void paths_readAllLines() {
	/////////////////////////////////////////		READALLLINES		////////////////////////////
		//	MÉTODOS EN FILES: Devuelve una lista con las lineas de texto contenidas en el fichero
		System.out.println("\n*************************************************************");
		System.out.println("método .readAllLines()");
		
		Path pt=Paths.get("datos.txt");
		try {
			List<String> cadenas = Files.readAllLines(pt);
			cadenas.forEach(c->System.out.println(c));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paths_lines() {
	/////////////////////////////////////////		LINE		////////////////////////////
		//	MÉTODOS EN FILES: Devuelve un Stream con las lineas del fichero
		System.out.println("\n*************************************************************");
		System.out.println("método .lines()");
			
		Contacto[] contactos=null;
		Path pt=Paths.get("datos.txt");
		try(Stream<String> st=Files.lines(pt)){		//lee el archivo y lo guardamos en Streams
			// con .split() transformamos las cadenas de caracteres en arrays de cadena de caracteres, 
			// con .map() transformamos cada elemento del stream (que es un array) en un objeto contacto
			// con .toArray() lo convertimos en un array
			contactos=st.map(s->s.split("[|]"))
					.map(d->new Contacto(d[0], d[2], Integer.parseInt(d[1])))
					.toArray(t->new Contacto[t]);
			for(Contacto con:contactos) {
				System.out.println(con.getNombre() +"-" +con.getEdad() +"-"+con.getEmail());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
