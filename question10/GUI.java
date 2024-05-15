package question10;

public class GUI {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				FinanceOffice m = new FinanceOffice("UIC FO");

				ControllerSimple c1 = new ControllerSimple(m);

				ViewSimple v1 = new ViewSimple(m, c1);

				ControllerGetDebt c2 = new ControllerGetDebt(m);
				ViewGetDebt v2 = new ViewGetDebt(m, c2);

				m.addPayer(new Student("UIC Student", 2000));
				try {
					m.addPayer(new Employee("Daniel", 1500));
					m.addPayer(new FacultyMember("Thompson", 1500));
				} catch (NegativeSalaryException e) {
					System.out.println("BUG! This must never happen!");
					System.exit(1);
				}
			}
		});
	}
}