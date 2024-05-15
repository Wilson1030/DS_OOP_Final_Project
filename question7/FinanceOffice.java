package question7;

public class FinanceOffice {
	public static void testFinanceOffice() {
		FinanceOffice f = new FinanceOffice("UIC FO");

		System.out.println(f.totalDebt() == 0);
		f.addPayer(new Student("Ms. Li", 1000));
		try {
			System.out.println(f.getDebt("Ms. Li") == 1000);
			System.out.println(f.totalDebt() == 1000);
			f.addPayer(new Employee("Daniel", 10000));
			System.out.println(f.getDebt("Ms. Li") == 1000);
			System.out.println(f.getDebt("Daniel") == -10000);
			System.out.println(f.totalDebt() == -9000);
			f.getDebt("Mr. Li");
			System.out.println(false);
		} catch (UnknownPayerException ex) {
			System.out.println(ex.getMessage().equals("Payer Mr. Li unknown"));
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
		try {
			f.pay("Daniel", 5000);
			System.out.println(f.getDebt("Ms. Li") == 1000);
			System.out.println(f.getDebt("Daniel") == -5000);
			f.pay("Mr. Li", 1);
			System.out.println(false);
		} catch (UnknownPayerException ex) {
			System.out.println(ex.getMessage().equals("Payer Mr. Li unknown"));
		} catch (NegativeSalaryException e) {
			System.out.println(false);
		}
		try {
			f.pay("Daniel", 10000);
		} catch (UnknownPayerException ex) {
			System.out.println(false);
		} catch (NegativeSalaryException e) {
			System.out.println(e.getMessage().equals("An employee cannot be overpaid by 5000 yuans!"));
		}
		try {
			System.out.println(f.getDebt("Ms. Li") == 1000);
			System.out.println(f.getDebt("Daniel") == -5000);
		} catch (UnknownPayerException ex) {
			System.out.println(false);
		}
	}
}