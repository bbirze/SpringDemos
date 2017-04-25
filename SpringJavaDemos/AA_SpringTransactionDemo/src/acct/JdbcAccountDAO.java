package acct;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class JdbcAccountDAO implements AccountDAO {
	
	public class AccountRowMapper implements RowMapper<Account> {

		@Override
		public Account mapRow(ResultSet rs, int index) throws SQLException {
			Account acct = new Account();
			acct.setAccountNumber(rs.getLong("ACCT_NUM"));
			acct.setBalance(rs.getDouble("BALANCE"));
			acct.setHolderName(rs.getString("HOLDERNAME"));
			return acct;
		}
	}

	private JdbcTemplate template;
	private AccountRowMapper mapper;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		template = new JdbcTemplate(ds);
		mapper = new AccountRowMapper();
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public Account getAccountByID(int accountNumber) {
		String SQL = "SELECT * FROM account WHERE acct_num=?";
		return template.queryForObject(SQL, mapper, accountNumber);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public void updateAccount(Account a) {
		String SQL = "UPDATE account SET balance=? holdername=? WHERE acct_num=?";
		template.update(SQL, a.getBalance(), a.getHolderName(), a.getAccountNumber());
	}

}
