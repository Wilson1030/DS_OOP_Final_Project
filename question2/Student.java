package question2;

public class Student extends Person{

	// tto build Student constructor
	public Student(String name, int debt) {
		super(name, debt);
	}

	@Override
	public void pay(int amount) {
		setDebt(getDebt() - amount);
	}

	public static void testStudent() {
		Student s = new Student("Ms. Li", 10000);

		System.out.println(s.getName() == "Ms. Li");
		System.out.println(s.getDebt() == 10000);
		s.setDebt(20000);
		System.out.println(s.getDebt() == 20000);
		s.pay(5000);
		System.out.println(s.getDebt() == 15000);
		s.pay(30000);
		System.out.println(s.getDebt() == -15000);
	}
}