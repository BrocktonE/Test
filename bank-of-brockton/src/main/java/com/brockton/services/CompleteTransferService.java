package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.util.ConnectionUtil;

public class CompleteTransferService {
	private static Logger log=Logger.getLogger(CompleteTransferService.class);

	public AccountDAO accountDAO;
	
	public CompleteTransferService() {
		accountDAO = new AccountDAOImpl();
	}
	
	public int completeTransfer(int accountNumber) throws DatabaseConnectionException {
		
		int count = 0;
		
				try (Connection connection = ConnectionUtil.getConnection()) {
					connection.setAutoCommit(false);
					
					try {
						count = accountDAO.completeTransfer(accountNumber);
					} catch (DatabaseConnectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					connection.commit();
					
				} catch (SQLException e) {
					
				}
				
			return count;
			
		
	}
	
}