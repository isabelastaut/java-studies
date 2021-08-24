package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		System.out.print("Enter number of employees: ");
		int numberEmployees = sc.nextInt();
		for (int i=1; i<=numberEmployees; i++) {
			System.out.println("Employee #" + i + " data:");

			System.out.print("Outsourced employee (y/n)? ");
			char ch = sc.next().strip().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if (ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee employee : employees) {
			System.out.println(employee.getName() + " - $ " + String.format("%.2f", employee.payment()));
		}
		
		sc.close();
	}

}
