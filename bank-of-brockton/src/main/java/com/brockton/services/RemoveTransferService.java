package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.util.ConnectionUtil;

public class RemoveTransferService {
	
	private static Logger log=Logger.getLogger(CompleteTransferService.class);

	public AccountDAO accountDAO;
	
	public RemoveTransferService() {
		accountDAO = new AccountDAOImpl();
	}
	
	public int removeTransfer(int accountNumberG, int accountNumberR) throws DatabaseConnectionException {
		
		int count = 0;
		
				try (Connection connection = ConnectionUtil.getConnection()) {
					connection.setAutoCommit(false);
					
					count = accountDAO.removeTransfer(accountNumberG, accountNumberR);
					
					connection.commit();
					
				} catch (SQLException e) {
					
				}
				
			return count;
			
		
	}
	
}


