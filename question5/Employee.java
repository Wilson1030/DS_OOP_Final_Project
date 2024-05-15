package question5;

public class Employee extends Person{
	// Parametrical construction
	public Employee() {}

	// to build Employee
	public Employee(String name, int salary) throws NegativeSalaryException{
		super(name, salary);
		if (salary < 0) {
			throw new NegativeSalaryException("An employee cannot have a negative salary!");
		}
		setDebt(-salary);
	}

	@Override
	public void pay(int amount) throws NegativeSalaryException{
		if (amount + getDebt() > 0) {
			throw new NegativeSalaryException("An employee cannot be overpaid by " + (amount + getDebt()) + " yuans!");
		}
		setDebt(amount + getDebt());
	}

	public static void testEmployee() {
		try {
			Employee e = new Employee("Daniel", -10000);
			System.out.println(false);
		} catch (NegativeSalaryException e) {
			System.out.println(e.getMessage() == "An employee cannot have a negative salary!");
		}
		try {
			Employee e = new Employee("Daniel", 0);
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
		try {
			Employee e = new Employee("Daniel", 10000);
			System.out.println(e.getName() == "Daniel");
			System.out.println(e.getDebt() == -10000);
			e.setDebt(20000);
			System.out.println(e.getDebt() == 20000);
			e.setDebt(-10000);
			System.out.println(e.getDebt() == -10000);
			e.pay(2000);
			System.out.println(e.getDebt() == -8000);
			e.pay(-2000);
			System.out.println(e.getDebt() == -10000);
			e.pay(10000);
			System.out.println(e.getDebt() == 0);
			e.pay(1);
			System.out.println(false);
		} catch (NegativeSalaryException e) {
			System.out.println(e.getMessage().equals("An employee cannot be overpaid by 1 yuans!"));
		}
	}
}