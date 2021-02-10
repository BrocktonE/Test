package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.AccountNumber;
import com.brockton.util.ConnectionUtil;

public class GiveTransferService {
		private static Logger log=Logger.getLogger(CompleteTransferService.class);

		public AccountDAO accountDAO;
		
		public GiveTransferService() {
			accountDAO = new AccountDAOImpl();
		}
		
		public int giveTransfer(int accountNumberG) throws DatabaseConnectionException, AccountNotFoundException {
			
			int count = 0;
			
					try (Connection connection = ConnectionUtil.getConnection()) {
						connection.setAutoCommit(false);
						
						try {
							count = accountDAO.giveTransfer(accountNumberG);
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