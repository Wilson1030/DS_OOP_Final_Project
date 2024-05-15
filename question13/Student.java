package question13;

public class Student {

	public static void testStudent() {
		try {
			Student s = new Student("Ms. Li", 10000);

			System.out.println(s.getName() == "Ms. Li");
			System.out.println(s.getDebt() == 10000);
			s.setDebt(20000);
			System.out.println(s.getDebt() == 20000);
			s.pay(5000);
			System.out.println(s.getDebt() == 15000);
			s.pay(30000);
			System.out.println(s.getDebt() == -15000);
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
	}
}