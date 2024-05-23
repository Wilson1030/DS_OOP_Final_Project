package question11;

import java.util.ArrayList;
import java.util.List;

public class FinanceOffice {
	private String name;
	private ArrayList<Payer> payers = new ArrayList<>();
	private List<ModelListener> listeners;

	// Parametrical construction
	public FinanceOffice() {
		this.payers = new ArrayList<>();
        this.listeners = new ArrayList<>();
	}

	// To build FinanceOffice
	public FinanceOffice(String name) {
		this.name = name;
        this.payers = new ArrayList<>();
        this.listeners = new ArrayList<>();
	}

	// To build addPayer
	public void addPayer(Payer payer) {
		payers.add(payer);
		notifyListeners();
	}

	// To build getDebt
	public int getDebt(String name) throws UnknownPayerException {
		// To find the name whether exist or not
		for (Payer payer : payers) {
			if (name.equals(payer.getName())) {
				return payer.getDebt();
			}
		}
		throw new UnknownPayerException("Payer " + name + " unknown");
	}

	// To build totalDebt
	public int totalDebt() {
		int count = 0;
		for (int i = 0; i < payers.size(); i++) {
			count += payers.get(i).getDebt();
		}
		return count;
	}
	
	// To build pay
	public void pay(String name, int debt) throws UnknownPayerException, NegativeSalaryException{
		// To find the name whether exist or not
		for (Payer payer : payers) {
			if (name.equals(payer.getName())) {
				if (debt + payer.getDebt() > 0) {
					throw new NegativeSalaryException("An employee cannot be overpaid by " + (debt + payer.getDebt()) + " yuans!");
				}
				payer.pay(debt);
				notifyListeners();
				return;
			}
		}
		throw new UnknownPayerException("Payer " + name + " unknown");	
	}

	// To identify payer's type
	public Payer getPayer(String name) throws UnknownPayerException {
        for (Payer payer : payers) {
            if (payer.getName().equals(name)) {
                return payer;
            }
        }
        throw new UnknownPayerException("Payer " + name + " unknown");
    }

	// Add a listener
	public void addListener(ModelListener listener) {
		listeners.add(listener);
	}

	// Notify all listeners
    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.update();
        }
    }

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