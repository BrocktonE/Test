package com.brockton.services;



import org.apache.log4j.Logger;

import com.brockton.dao.ActionDAO;
import com.brockton.dao.ActionDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;


public class ViewAccountService {
	private static Logger log=Logger.getLogger(ViewAccountService.class);

	ActionDAO actionDAO;
	
	public ViewAccountService() {
		actionDAO = new ActionDAOImpl();
			
	}
	public Account viewAccount(int customerId) throws AccountNotFoundException, DatabaseConnectionException {
	Account account = actionDAO.viewAccount(customerId);
		
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("An Account with Customer ID" + customerId + "was not found");

		}
	
	}

}
