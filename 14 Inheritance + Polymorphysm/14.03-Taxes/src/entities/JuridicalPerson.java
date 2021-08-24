package entities;

public class JuridicalPerson  extends Person {

	private Integer employees;
	
	public JuridicalPerson() {
		
	}

	public JuridicalPerson(String name, Double income, Integer employees) {
		super(name, income);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}
	
	@Override
	public Double taxes() {
		if (employees > 10) {
			return 0.14 * getIncome();
		}
		else {
			return 0.16 * getIncome();
		}
	}
}
