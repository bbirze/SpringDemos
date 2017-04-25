package acct;

public interface AccountDAO {

	public Account getAccountByID(int accountNumber);
	public void updateAccount(Account a);
}
