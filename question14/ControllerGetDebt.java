package question14;

public class ControllerGetDebt extends Controller {
    public ControllerGetDebt(FinanceOffice m) {
        super(m);
    }

    public String getDebt(String name) {
        try {
            int debt = m.getDebt(name);
            return name + " has a debt of " + debt + " yuans.";
        } catch (UnknownPayerException e) {
            return e.getMessage();
        }
    }
}