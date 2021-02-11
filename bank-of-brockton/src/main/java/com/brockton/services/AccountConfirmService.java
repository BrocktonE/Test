package com.brockton.services;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import org.apache.log4j.Logger;

import com.brockton.model.Withdrawal;
import com.brockton.ui.DepositMenu;

public class AccountConfirmService {
	private static Logger log=Logger.getLogger(DepositMenu.class);

	AccountDAO accountDAO;

	public AccountConfirmService() {
		accountDAO = new AccountDAOImpl();

	}

	public Withdrawal getUNandPW(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {

		Withdrawal count = null;
		try {
			Withdrawal account = accountDAO.getUNandPW(accountNumber);
			
			if (account != null) {
				return account;
			} else {
				log.error("Please enter an Account you currently own");
			}

	
				
			

		} catch (DatabaseConnectionException e) {

		}
		return count;
	}

}

