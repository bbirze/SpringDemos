package acct;

public interface AccountManager {

	public void transfer(int acct1, int acct2, double amount)
			throws NoMoneyException;
	
	public String getAccountInfo(int accountNumber);
}
