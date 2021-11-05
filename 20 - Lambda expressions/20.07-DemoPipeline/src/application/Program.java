package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		
		Stream<Integer> st1 = list.stream().map(x -> x * 10); // multiplica todos os itens por 10
		
		int sum = list.stream().reduce(0,  (x, y) -> x + y); // soma todos os itens
		
		List<Integer> newList = list.stream()
				.filter(x -> x % 2 == 0) // deixa so os itens pares
				.map(x -> x * 10) // multiplica os itens restantes por 10
				.collect(Collectors.toList()); // converte para lista
		System.out.println(Arrays.toString(newList.toArray()));
	}

}
