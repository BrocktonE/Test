package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.dao.EmployeeDAO;
import com.brockton.dao.EmployeeDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Employee;
import com.brockton.util.ConnectionUtil;

public class EmployeeService {
	private static Logger log=Logger.getLogger(EmployeeService.class);
		
		public EmployeeDAO employeeDAO;
		
		public EmployeeService () {
			employeeDAO = new EmployeeDAOImpl();
			
			
		}
		
		public int createEmployeeUnPw(Employee employee) {
			int count = 0;
			
			
			try (Connection connection = ConnectionUtil.getConnection()) {
				
				connection.setAutoCommit(false);
				
				count = employeeDAO.createEmployeeUnPw(employee);
				
				connection.commit();
				
			} catch (SQLException | DatabaseConnectionException e) {
				log.trace(e.getMessage());
			}
			
		return count;
		}
	}


