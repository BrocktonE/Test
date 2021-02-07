package com.brockton.dao;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Employee;

public interface EmployeeLoginDAO {
	
	public Employee lookforUNPW(String userName, String passWord) throws DatabaseConnectionException; 
		
	}


