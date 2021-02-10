package com.brockton.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.util.ConnectionUtil;

public class BalanceService {
	private static Logger log=Logger.getLogger(BalanceService.class);

	AccountDAO accountDAO;
	
	public BalanceService() {
		accountDAO = new AccountDAOImpl();
	
	}
	
	public Withdrawal getBalance(int accountNumber) throws DatabaseConnectionException, AccountNotFoundException {
		Withdrawal balance = accountDAO.getBalance(accountNumber);
		
		if (balance != null) {
			return balance;
		} else {
			throw new AccountNotFoundException("Your account number: " + accountNumber + "was not found");
		}
	}

}
