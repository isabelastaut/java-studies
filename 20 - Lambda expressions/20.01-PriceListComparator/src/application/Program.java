package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		String path = ""; // .txt que traz informações no formato "nome do produto, preço"
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			// lendo o .txt e adicionando os valores a uma lista
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			// ordenando a lista de produtos
			list.sort(new MyComparator());
			
			/* Alternativamente, poderia ser:
			
			list.sort((p1, p2) -> p1.getName.toUpperCase().compareTo(p2.getName().toUpperCase()));
			 
			 */
			
			// imprimindo a lista de produtos ordenada
			for (Product p: list) {
				System.out.println(p);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
