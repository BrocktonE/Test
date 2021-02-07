package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.util.ConnectionUtil;

public class WithdrawalService {
	private static Logger log=Logger.getLogger(WithdrawalService.class);

		public AccountDAO accountDAO;
		
		public WithdrawalService() {
			accountDAO = new AccountDAOImpl();
			
		}
		public int makeWithdrawal(int withdrawal, int accountNumber) {
			
		
			
			int count = 0;
			
 				try (Connection connection = ConnectionUtil.getConnection()) {
				
			    	connection.setAutoCommit(false);
				
			    	count = accountDAO.makeWithdrawal(withdrawal, accountNumber);
			    	
			    	connection.commit();
				
			} catch (SQLException | DatabaseConnectionException e) {
 				
			}
		return count;
}

}