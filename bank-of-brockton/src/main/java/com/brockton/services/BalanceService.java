package com.brockton.services;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;

public class BalanceService {
	private static Logger log=Logger.getLogger(BalanceService.class);

	AccountDAO accountDAO;
	
	public BalanceService() {
		accountDAO = new AccountDAOImpl();
	
	}
	
	public Withdrawal getBalance(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		Withdrawal balance = accountDAO.getBalance(accountNumber);
		
		if (balance != null) {
			return balance;
		} else {
			throw new AccountNotFoundException("Your account number: " + accountNumber + "was not found");
		}
	}

}
