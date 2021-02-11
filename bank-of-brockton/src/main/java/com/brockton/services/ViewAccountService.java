package com.brockton.services;



import java.util.List;

import org.apache.log4j.Logger;

import com.brockton.dao.ActionDAO;
import com.brockton.dao.ActionDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;


public class ViewAccountService {
	private static Logger log=Logger.getLogger(ViewAccountService.class);

	ActionDAO actionDAO;
	
	public ViewAccountService() {
		actionDAO = new ActionDAOImpl();
			
	}
	public List<Account> viewAccount(int customerId) throws AccountNotFoundException, DatabaseConnectionException {
	List accountList = actionDAO.viewAccount(customerId);
		
		if (accountList != null) {
			System.out.println(accountList);
			return accountList;
		} else {
			throw new AccountNotFoundException("An Account with Customer ID" + customerId + "was not found");

		}
	
	}

}
