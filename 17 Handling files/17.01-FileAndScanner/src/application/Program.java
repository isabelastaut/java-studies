package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
/*		
		// instanciando o arquivo
		File file = new File("");

		// instanciando o scanner a partir do arquivo
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) { // testa se ainda tem alguma linha no arquivo
				System.out.println(sc.nextLine()); // imprime a linha
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if (sc != null)	sc.close(); // evita NullPointerException em caso de erro ao instanciar o Scanner
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------
		
		
		String path = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){			
			String line = br.readLine(); // le uma linha do arquivo e se o arquivo estiver no final ele retorna null
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------

		
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		String path = "";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { // o parametro true indica que nao se quer recriar o arquivo, e sim adicionar esse texto ao final do que ja existir
			for (String line : lines) {
				bw.write(line);
				bw.newLine(); // o método write não tem quebra de linha implicita
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
//---------------------------------------------------------------------------------------------------------------------------


		File dirPath = new File(path); // um arquivo file pode ser tanto o caminho de um arquivo quanto de uma pasta 
		
		File[] folders = dirPath.listFiles(File::isDirectory); // lista somente diretórios
		
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = dirPath.listFiles(File::isFile); // lista somente arquivos
		
		boolean success = new File(path + "\\exemplo").mkdir(); // cria uma subpasta chamada exemplo
		//success fica com o valor True
		
		
//---------------------------------------------------------------------------------------------------------------------------

		//path.getName() pega o nome do arquivo
		//path.getPath() pega o caminho do arquivo
		//path.getParent() pega só o caminho até o diretório
		
		*/
		
	}
	
}
