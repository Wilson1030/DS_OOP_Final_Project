package question9;

public class FacultyMember extends Employee{
	// Parametrical construction
	public FacultyMember() {}

	// to build FacultyMember
	public FacultyMember(String name, int salary) throws NegativeSalaryException{
		super(name, salary);
		if (salary < 0) {
			throw new NegativeSalaryException("An employee cannot have a negative salary!");
		}
		setDebt(-salary);
	}

	@Override
	public void pay(int amount) {
		setDebt(amount + getDebt());
	}

	public static void testFacultyMember() {
		try {
			FacultyMember f = new FacultyMember("Daniel", -10000);
			System.out.println(false);
		} catch (NegativeSalaryException e) {
			System.out.println(e.getMessage() == "An employee cannot have a negative salary!");
		}
		try {
			FacultyMember f = new FacultyMember("Daniel", 0);
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
		try {
			FacultyMember f = new FacultyMember("Daniel", 10000);
			System.out.println(f.getName() == "Daniel");
			System.out.println(f.getDebt() == -10000);
			f.setDebt(20000);
			System.out.println(f.getDebt() == 20000);
			f.setDebt(-10000);
			System.out.println(f.getDebt() == -10000);
			f.pay(2000);
			System.out.println(f.getDebt() == -8000);
			f.pay(-2000);
			System.out.println(f.getDebt() == -10000);
			f.pay(10000);
			System.out.println(f.getDebt() == 0);
			f.pay(10000);
			System.out.println(f.getDebt() == 10000);
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
	}
}