package com.brockton.services;



import org.apache.log4j.Logger;


import com.brockton.dao.CustomerLoginDAO;
import com.brockton.dao.CustomerLoginDAOImp;
import com.brockton.exceptions.CustomerNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;

import com.brockton.model.Withdrawal;

public class CustLoginService {
	private static Logger log=Logger.getLogger(CustLoginService.class);

	public CustomerLoginDAO customerLoginDAO;
	
	public CustLoginService() {
		customerLoginDAO = new CustomerLoginDAOImp();
		
	}
	
	public Withdrawal lookforUNandPW(String userName, String passWord) throws CustomerNotFoundException, DatabaseConnectionException {
		Withdrawal customer = customerLoginDAO.lookforUNandPW(userName, passWord);
		
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("Your Login Credentials were Invalid");
			
		}	
				
	}
		
}


