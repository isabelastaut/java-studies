package services;

import java.util.List;

public class CalculationService {

	public static <T extends Comparable<T>> T max(List<T> list) { // aceita objetos do tipo T contato que seja subtipo de Comparable<T>
		
		// programacao defensiva
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		}
		
		//buscando item de maior valor na lista
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
}
