package com.brockton.dao;


import java.sql.SQLException;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.model.AccountNumber;
import com.brockton.model.Application;

import com.brockton.model.Withdrawal;



public interface AccountDAO {
	
	public int createApplication(Application application) throws SQLException, DatabaseConnectionException;
	public Withdrawal getBalance(int accountNumber) throws DatabaseConnectionException, AccountNotFoundException;
	public int makeWithdrawal(int accountNumber, int withdrawal) throws DatabaseConnectionException, AccountNotFoundException;
	public int makeDeposit(int accountNumber, int deposit) throws DatabaseConnectionException, AccountNotFoundException;
	public int transfer(Account accounts) throws SQLException, DatabaseConnectionException, AccountNotFoundException;
	public int completeTransfer(int accountNumberR) throws DatabaseConnectionException;
	public Withdrawal getUNandPW(int accountNumber) throws DatabaseConnectionException, AccountNotFoundException;
	public int giveTransfer(int accountNumberG, int accountNumberR) throws DatabaseConnectionException, AccountNotFoundException;
//	public int removeTransfer(int accountNumberG, int accountNumberR) throws SQLException, DatabaseConnectionException;
	public int getPendingTransfer(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException;
	
	
}
