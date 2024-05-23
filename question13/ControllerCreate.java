package question13;

public class ControllerCreate extends Controller {
    public ControllerCreate(FinanceOffice m) {
        super(m);
    }

    public String create(String name, String amount, int type) {
        try {
            int debt = Integer.parseInt(amount);
            Payer payer;
            switch (type) {
                case 0:
                    payer = new Student(name, debt);
                    break;
                case 1:
                    payer = new Employee(name, debt);
                    break;
                case 2:
                    payer = new FacultyMember(name, debt);
                    break;
                default:
                    return "Unknown payer type.";
            }
            m.addPayer(payer);
            return "";
        } catch (NumberFormatException e) {
            return e.getMessage();
        } catch (NegativeSalaryException e) {
            return e.getMessage();
        }
    }
}