package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Product> list = new ArrayList<>();
			
			// reading the file:
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			
			// calculating the average price:
			double avg = list.stream() // converting the list to stream
						.map(p -> p.getPrice()) // keeping only the prices of the products
						.reduce(0.0, (x,y) -> x + y) / list.size(); // summing the prices and dividing by the number of products
			
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			
			// getting the products with price below average
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			List<String> names = list.stream() // converting the list to a stream
					.filter(p -> p.getPrice() < avg) // filtering only items with prices below the average
					.map(p -> p.getName()) // keeping only the names of the products
					.sorted(comp.reversed()) // sorting the list by reverse alphabetical order
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
					
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
