package com.brockton.services;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.dao.CustomerLoginDAO;
import com.brockton.dao.CustomerLoginDAOImp;
import com.brockton.exceptions.CustomerNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Customer;
import com.brockton.util.ConnectionUtil;

public class CustLoginService {
	private static Logger log=Logger.getLogger(CustLoginService.class);

	public CustomerLoginDAO customerLoginDAO;
	
	public CustLoginService() {
		customerLoginDAO = new CustomerLoginDAOImp();
		
	}
	
	public Customer lookforUNandPW(String userName, String passWord) throws CustomerNotFoundException, DatabaseConnectionException {
		Customer customer = customerLoginDAO.lookforUNandPW(userName, passWord);
		
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("Your Login Credentials were Invalid");
			
		}	
				
	}
		
}


