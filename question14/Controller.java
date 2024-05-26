package question14;

public class Controller {
    protected FinanceOffice m;

    public Controller(FinanceOffice m) {
        this.m = m;
    }

    protected void shutdown() {
        m.saveData();
        System.exit(0);
    }

}