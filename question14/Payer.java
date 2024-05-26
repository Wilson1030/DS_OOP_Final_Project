package question14;

import java.io.Serializable;

public interface Payer extends Serializable{
    public abstract String getName();
    
    public abstract int getDebt();
    
    public abstract void pay(int amount) throws NegativeSalaryException;
}