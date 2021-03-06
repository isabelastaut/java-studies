package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int contractNo = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date contractDate = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		
		Contract contract = new Contract(contractNo, contractDate, contractValue);
		
		ContractService cService = new ContractService(new PaypalService());
		cService.processContract(contract, installments);
		
		System.out.println("Installments:");
		for (Installment inst : contract.getInstallments()) {
			System.out.println(inst);
		}
		
		sc.close();
	}
}
