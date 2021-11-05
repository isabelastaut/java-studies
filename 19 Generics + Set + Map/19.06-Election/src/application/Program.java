package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		String path = "";
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				// Caso o nome ainda não exista no Map
				if(!votes.containsKey(name)) {
					votes.put(name, count);
				}
				
				// Caso o nome já exista no Map
				else {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				}
				line = br.readLine();
			}
			
			// loop para percorrer todas as chaves contidas no Map
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
