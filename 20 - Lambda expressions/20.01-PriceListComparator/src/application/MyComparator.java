package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		// compara o nome dos produtos para coloca-los em ordem alfabetica
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}
}
