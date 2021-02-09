package com.brockton.dao;


import com.brockton.exceptions.DatabaseConnectionException;

import com.brockton.model.Withdrawal;

public interface CustomerLoginDAO {
	
	public Withdrawal lookforUNandPW(String userName, String passWord) throws DatabaseConnectionException; 
		
	}
	
	
		
		
	


