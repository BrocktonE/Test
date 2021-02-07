package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.util.ConnectionUtil;

public class DepositService {
	private static Logger log=Logger.getLogger(DepositService.class);

	public AccountDAO accountDAO;
	
	public DepositService() {
		accountDAO = new AccountDAOImpl();
		
	}
	public int makeWithdrawal(int deposit, int accountNumber) {
		
	
		
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