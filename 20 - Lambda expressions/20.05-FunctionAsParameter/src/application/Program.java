package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import service.ProductService;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.0));
		list.add(new Product("Mouse", 50.0));
		list.add(new Product("Tablet", 350.5));
		list.add(new Product("HD Case", 80.9));
		
		ProductService ps = new ProductService();
		
		// na expressao lamba se define como quer filtrar a seleçao dos produtos considerados
		double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
		
		System.out.println("Sum = " + String.format("%.2f", sum));
	}
}
