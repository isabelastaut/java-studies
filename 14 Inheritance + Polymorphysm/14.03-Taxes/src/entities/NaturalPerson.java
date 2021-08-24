package entities;

public class NaturalPerson extends Person {

	private Double medicalExpenses;
	
	public NaturalPerson() {
		
	}

	public NaturalPerson(String name, Double income, Double medicalExpenses) {
		super(name, income);
		this.medicalExpenses = medicalExpenses;
	}

	public Double getMedicalExpenses() {
		return medicalExpenses;
	}

	public void setMedicalExpenses(Double medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}
	
	@Override
	public Double taxes() {
		if (getIncome() < 20000.0) {
			return (0.15 * getIncome()) - (0.5 * medicalExpenses);
		}
		else {
			return (0.25 * getIncome()) - (0.5 * medicalExpenses);
		}
	}
}
