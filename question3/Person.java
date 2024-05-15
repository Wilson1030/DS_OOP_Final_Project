package question3;

public abstract class Person implements Payer{
	private String name;
	private int debt;

	// Parametrical construction
	public Person() {}
	
	// to build Person constructor
	public Person(String name, int debt) {
		this.name = name;
		this.debt = debt;
	}

	protected void setDebt(int debt) {
		this.debt = debt;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getDebt() {
		return debt;
	}

	@Override
	public abstract void pay(int amount) throws NegativeSalaryException;


	public static void testPerson() {
	}
}