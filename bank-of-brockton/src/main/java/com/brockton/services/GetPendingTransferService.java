package com.brockton.services;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.AccountNumber;
import com.brockton.model.Withdrawal;

public class GetPendingTransferService {

	private static Logger log=Logger.getLogger(GetPendingTransferService.class);

	AccountDAO accountDAO;
	
	public GetPendingTransferService() {
		accountDAO = new AccountDAOImpl();
	
	}
	
	public int getPendingTransfer(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		int accountNumberG = accountDAO.getPendingTransfer(accountNumber);
		
		if (accountNumberG != 0) {
			return accountNumberG;
		} else {
			throw new AccountNotFoundException("Your account number: " + accountNumber + "was not found");
		}
	}

}
