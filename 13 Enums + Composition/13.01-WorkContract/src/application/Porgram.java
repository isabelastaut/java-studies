package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Porgram {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departmentName = sc.nextLine();
			
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double workerBaseSalary = sc.nextDouble();
			
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
			
		System.out.print("How many contracts to this worker? ");
		int contracts = sc.nextInt();
		for(int i=1; i <= contracts; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration (hours): ");
			int duration = sc.nextInt();
				
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			worker.addContract(contract);
		}
			
		System.out.println();
		System.out.print("Enter onth and year to calculare income (MM/YYYY): ");
		String monthAndYear = sc.nextLine();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Deparment: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear +String.format("%.2f", worker.income(year, month)));
		
			
		sc.close();
	}
}
