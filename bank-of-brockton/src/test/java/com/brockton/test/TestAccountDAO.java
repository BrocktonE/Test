package com.brockton.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.CustomerNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.exceptions.EmployeeNotFoundException;
import com.brockton.model.Account;
import com.brockton.model.Application;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.ApplicationService;
import com.brockton.services.BalanceService;
import com.brockton.services.CustLoginService;
import com.brockton.services.EmployeeLoginService;
import com.brockton.services.PullApplicationService;
import com.brockton.services.ViewAccountService;
import com.brockton.services.ViewTransactionsService;
import com.brockton.ui.ApplicationMenu;



public class TestAccountDAO {
	@Test
	void testAccountDAOImplBalance() throws AccountNotFoundException, DatabaseConnectionException {
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		assert (accountDAOImpl.getBalance(22)) != null;
	}
	@Test
	void testBalanceService() throws AccountNotFoundException, DatabaseConnectionException {
		BalanceService balanceService = new BalanceService();
		assert (balanceService.getBalance(22)) != null;
		
	}
	@Test
	void testPullApplicationService() throws AccountNotFoundException, DatabaseConnectionException {
		PullApplicationService pullApplicationService = new PullApplicationService();
		assert (pullApplicationService.getApplications()) != null;
	
	}
	@Test 
	void testViewTransactionsService() throws DatabaseConnectionException, AccountNotFoundException {
	ViewTransactionsService viewTransactionsService = new ViewTransactionsService();
	assert (viewTransactionsService.viewTransactions()) != null;
		
	}
	@Test
	void testEmployeeLoginService() throws DatabaseConnectionException, AccountNotFoundException, EmployeeNotFoundException {
		EmployeeLoginService employeeLoginService = new EmployeeLoginService();
		assert (employeeLoginService.lookforUNPW("Agent007", "L2kill")) != null;

	}
	@Test
	void testCustLoginService() throws DatabaseConnectionException, AccountNotFoundException, EmployeeNotFoundException, CustomerNotFoundException {
		CustLoginService custLoginService = new CustLoginService();
		assert (custLoginService.lookforUNandPW("Jimmy50", "password")) != null;
	
	}
	@Test
	void testViewAccountService() throws AccountNotFoundException, DatabaseConnectionException  {
	ViewAccountService viewAccountService = new ViewAccountService();
	assert (viewAccountService.viewAccount(2)) != null;
	
	
	}
	@Test
	void testAccountConfirmService() throws AccountNotFoundException, DatabaseConnectionException  {
	AccountConfirmService accountConfirmService = new AccountConfirmService();
	assert (accountConfirmService.getUNandPW(22)) != null;

	}
	@Test
	void testAccountDAOImpl() throws AccountNotFoundException, DatabaseConnectionException {
	AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
	assert (accountDAOImpl.getBalance(22)) != null;
		
	}
	@Test
	 void testAccountDAO() {
	Account account = new Account();
	 account.getId();
	assert(account.getId()==(0));
	
	
	}
	
}

