package com.brockton.services;

import org.apache.log4j.Logger;


import com.brockton.dao.EmployeeLoginDAO;
import com.brockton.dao.EmployeeLoginDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.exceptions.EmployeeNotFoundException;
import com.brockton.model.Employee;

public class EmployeeLoginService {
	private static Logger log=Logger.getLogger(EmployeeLoginService.class);

	public EmployeeLoginDAO employeeLoginDAO;
	
	public EmployeeLoginService() {
		employeeLoginDAO = new EmployeeLoginDAOImpl();
		
	}
	
	public Employee lookforUNPW(String userName, String passWord) throws EmployeeNotFoundException, DatabaseConnectionException {
		Employee employee = employeeLoginDAO.lookforUNPW(userName, passWord);
		
		if (employee != null) {
			return employee; 
		} else {
			throw new EmployeeNotFoundException("Your Login Credentials are Invalid");
		}
		
	}

}
