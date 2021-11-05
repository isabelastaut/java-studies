package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		String path = "";
		File sourceFile = new File(path); // recebendo o arquivo de entrada
		String sourceFolder = sourceFile.getParent();
		
		boolean success = new File(sourceFolder + "\\out").mkdir(); // criando o diretório para o arquivo de saída
		String targetFile = sourceFolder + "\\out\\summary.csv"; // criando o arquivo de saída
		
		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){	
			String line = br.readLine();
			while (line != null) {
				String[] product = line.split(",");
				String name = product[0];
				double price = Double.parseDouble(product[1]);
				int quantity = Integer.parseInt(product[2]);
				
				products.add(new Product(name, price, quantity));
				
				line = br.readLine();
			}
			
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
				
				for (Product item : products) {
					bw.write(item.getName() + ", R$" + String.format("%.2f",  item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFile + " successfully created.");
			}
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
