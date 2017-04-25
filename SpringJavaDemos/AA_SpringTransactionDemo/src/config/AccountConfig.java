package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("acct")
@EnableTransactionManagement
public class AccountConfig {
	
	@Bean
	public DataSource acctDataSource()  {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/account");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager()  {
		return new DataSourceTransactionManager(acctDataSource());
	}

}
