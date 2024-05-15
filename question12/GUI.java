package question12;

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

				ControllerPay c3 = new ControllerPay(m);
				ViewPay v3 = new ViewPay(m, c3);

				ControllerCreate c4 = new ControllerCreate(m);
				ViewCreate v4 = new ViewCreate(m, c4);
			}
		});
	}
}