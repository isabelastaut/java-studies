package application;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(1.1, 2.2, 3.3);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}
	
	//recebe qualquer lista de tipo Number e subtipos, e copia os valores para qualquer lista de supertipo de Number
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}
	
	//metodo para imprimir qualquer tipo de lista
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj + " ");
		}
		System.out.println();
	}
}
