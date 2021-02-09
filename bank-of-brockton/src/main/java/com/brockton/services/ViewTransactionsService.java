package com.brockton.services;

import java.util.List;
import org.apache.log4j.Logger;
import com.brockton.dao.ActionDAO;
import com.brockton.dao.ActionDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Transactions;

public class ViewTransactionsService {
	private static Logger log=Logger.getLogger(ViewTransactionsService.class);

public ActionDAO actionDAO;
	
	public ViewTransactionsService() {
		actionDAO = new ActionDAOImpl();
			
	}
	public List<Transactions> viewTransactions() throws DatabaseConnectionException, AccountNotFoundException {
	List transactionsList = actionDAO.viewTransactions();
	
	if (transactionsList !=null) {
		for(int i = 0; i<transactionsList.size(); i++) {
			System.out.println(transactionsList.get(i));	
		}
		return transactionsList;
		
	} else {
		throw new AccountNotFoundException("Applications not found");
		}
	
	}
}
		
	

