package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FuncionesIntermediasLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FuncionesIntermediasLambda funciones = new FuncionesIntermediasLambda();
		
		funciones.distict();
		funciones.limit();
		funciones.skip();
		funciones.filter();
		funciones.map();
		funciones.peek();
	}
	
	public void distict(){
	/////////////////////////////////////////		DISTINCT	////////////////////////////
		//	Devuelve un Stream eliminando los elementos duplicados, según aplicación de equals().
		System.out.println("\n*************************************************************");
		System.out.println("método .distinct()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		Stream<Integer> st2=st.distinct();
		st2.forEach(n->System.out.print(n));	
	}
	
	public void limit(){
	/////////////////////////////////////////		LIMIT	////////////////////////////
		//	Devuelve un nuevo Stream con los n primeros elementos del mismo
		System.out.println("\n*************************************************************");
		System.out.println("método .limit()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Stream<Integer> st2=st.limit(3);
		st2.forEach(n->System.out.print(n));
	}
	
	public void skip() {
	/////////////////////////////////////////		SKIP	////////////////////////////
		//	Devuelve un nuevo Stream saltándose los n primeros elementos
		System.out.println("\n*************************************************************");
		System.out.println("método .skip()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
			
		Stream<Integer> st2=st.skip(3);
		st2.forEach(n->System.out.print(n));
	}
	
	public void filter() {
	/////////////////////////////////////////		FILTER	////////////////////////////
		//	Aplica un filtro sobre el Stream, devolviendo un nuevo Stream con los elementos que cumplen el predicado
		System.out.println("\n*************************************************************");
		System.out.println("método .filter()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		Stream<Integer>st2=st.filter(s->s>3);
		st2.forEach(n->System.out.print(n));
	}
	
	public void map() {
	/////////////////////////////////////////		MAP		////////////////////////////
		//	Transforma cada elemento del Stream en otro según el criterio definido por el objeto Function que se le pasa como parámetro
		System.out.println("\n*************************************************************");
		System.out.println("método .map()");
		Stream<Integer> st=Stream.of(2,5,7,3,6,2,3);
		
		Stream<Object>st2=st.map(s->s.toString()+" elemento; ".toUpperCase());
		st2.forEach(n->System.out.print(n));
	}
	
	public void peek() {
	/////////////////////////////////////////		KEEP	////////////////////////////
		//	Si no termina con una expresión final no se ejecuta, funciona en modo lazy
		System.out.println("\n*************************************************************");
		System.out.println("método .keep()");
		List<String> lista= Arrays.asList("hola","que" ,"tal", "estas","tu");
		
	    lista.stream().peek((cadena)-> {
	      System.out.println("***inicio****");
	      System.out.println(cadena);
	      System.out.println("****fin inicio****");
	    })
	    .filter((cadena)->cadena.length()>3).peek((cadena)-> {
	      System.out.println("-----filtro--------");
	      System.out.println(cadena);
	      System.out.println("-----fin filtro-----");
	    })
	    .map((cadena)->cadena.toUpperCase()).peek((cadena)-> {
	      System.out.println(">>>>>>mayusculas>>>>>>");
	      System.out.println(cadena);
	      System.out.println(">>>>>>>fin mayusculas>>>>>>");
	    })
	    .forEach(System.out::println);
	}
}
