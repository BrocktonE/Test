package com.brockton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;
import com.brockton.model.Transfer;
import com.brockton.model.Withdrawal;
import com.brockton.util.ConnectionUtil;


public interface AccountDAO {
	
	public int createApplication(Application application) throws SQLException;
	public Withdrawal getBalance(int accountNumber) throws DatabaseConnectionException, AccountNotFoundException;
	public int makeWithdrawal(int accountNumber, int withdrawal) throws DatabaseConnectionException;
	public int makeDeposit(int accountNumber, int deposit) throws DatabaseConnectionException;
	public int transfer(Transfer transfer) throws SQLException;
	public int completeTransfer(int accountNumber) throws DatabaseConnectionException;
	
}
