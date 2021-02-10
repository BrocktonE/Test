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

		Withdrawal count = null;
		try {
			Withdrawal account = accountDAO.getUNandPW(accountNumber);

			return account;

		} catch (AccountNotFoundException | DatabaseConnectionException e) {

		}
		return count;
	}

}

