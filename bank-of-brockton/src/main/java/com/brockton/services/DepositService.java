package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.util.ConnectionUtil;

public class DepositService {
	private static Logger log=Logger.getLogger(DepositService.class);

	public AccountDAO accountDAO;
	
	public DepositService() {
		accountDAO = new AccountDAOImpl();
		
	}

		
	public int makeDeposit(int deposit, int accountNumber) throws DatabaseConnectionException, AccountNotFoundException {
		
	
		
		int count = 0;
		
				try (Connection connection = ConnectionUtil.getConnection()) {
			
		    	connection.setAutoCommit(false);
			
		    	count = accountDAO.makeDeposit(deposit, accountNumber);
		    	
		    	connection.commit();
			
		} catch (SQLException | DatabaseConnectionException e) {
		
		}
	return count;
}

}
