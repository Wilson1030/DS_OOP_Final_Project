package question12;

public class ControllerPay extends Controller {
    public ControllerPay(FinanceOffice m) {
        super(m);
    }

    public String pay(String name, String amount) {
        try {
            int debt = Integer.parseInt(amount);
            m.pay(name, debt);
            return "";
        } catch (UnknownPayerException e) {
            return e.getMessage();
        } catch (NegativeSalaryException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }
}