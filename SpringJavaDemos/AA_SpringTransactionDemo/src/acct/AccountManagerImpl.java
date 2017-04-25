package acct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("accountMgr")
public class AccountManagerImpl implements AccountManager {

	private AccountDAO accountDAO;
	
	@Autowired
	public void setAccountDAO(AccountDAO accountDAO)  {
		this.accountDAO = accountDAO;
	}
	
	@Transactional(readOnly=true)
	public String getAccountInfo(int accountNumber) {
		Account a = accountDAO.getAccountByID(accountNumber);
		return a.toString();
	}

	@Transactional(rollbackFor=NoMoneyException.class, timeout=10,
			propagation=Propagation.REQUIRED)
	public void transfer(int acct1, int acct2, double amount) 
			throws NoMoneyException {

		Account a1 = accountDAO.getAccountByID(acct1);
		Account a2 = accountDAO.getAccountByID(acct2);
		
		double a1Balance = a1.getBalance();
		if(a1Balance - amount < 0)
			throw new NoMoneyException();
		
		double a2Balance = a2.getBalance();
		a1Balance -= amount;
		a2Balance += amount;
		a1.setBalance(a1Balance);
		a2.setBalance(a2Balance);	
		accountDAO.updateAccount(a1);
		accountDAO.updateAccount(a2);
	}
}
