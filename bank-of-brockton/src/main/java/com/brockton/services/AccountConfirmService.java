package com.brockton.services;



import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;

import com.brockton.model.Withdrawal;


public class AccountConfirmService {

AccountDAO accountDAO;
	
	public AccountConfirmService() {
		accountDAO = new AccountDAOImpl();
	
	}
	
	public Withdrawal getUNandPW(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		Withdrawal account = accountDAO.getUNandPW(accountNumber);
		
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("Your account number: " + accountNumber + "was not found");
		}
	}

}

