package question2;

public interface Payer {
	public abstract String getName();

	public abstract int getDebt();

	public abstract void pay(int amount);
}