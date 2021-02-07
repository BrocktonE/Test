package com.brockton.dao;


import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Customer;

public interface CustomerLoginDAO {
	
	public Customer lookforUNandPW(String userName, String passWord) throws DatabaseConnectionException; 
		
	}
	
	
		
		
	


