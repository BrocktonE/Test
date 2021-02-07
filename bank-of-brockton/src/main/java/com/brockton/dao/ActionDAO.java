package com.brockton.dao;

import java.util.List;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.model.Application;
import com.brockton.model.Transactions;

public interface ActionDAO {
	
	public List<Application> getApplications() throws DatabaseConnectionException;
	public int approveAccount (int id, String approve) throws DatabaseConnectionException;
	public Account viewAccount(int customerId) throws DatabaseConnectionException, AccountNotFoundException;
	public List<Transactions> viewTransactions() throws DatabaseConnectionException;
}


