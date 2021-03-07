package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.respositories.EmployeeDAO;
import com.revature.respositories.EmployeeDAOImpl;
import com.revature.util.ConnectionUtil;

public class EmployeeService {
	
	public static EmployeeDAO eDao = new EmployeeDAOImpl();
	
	public static boolean insert(Employee e) {
		
		return eDao.insert(e);
			
			
		}
	
	public static boolean update(Employee e) {
		
		return eDao.update(e);
	
	
	
	
	}

		public static List<Employee> findAll() {
			return eDao.findAll();
		}
		
		public static Employee findByUsername(String username) {
			List<Employee> all = eDao.findAll();
			
			for (Employee e : all ) {
				if (e.getUsername().equals(username)) {
					return e;
				}
			}
			
			return null;
		}
		
		
		//confirm login method
		public static Employee confirmLogin(String username, String password) {
			
			Employee e = findByUsername(username);
			
			if (e == null) {
				return null;
			}
			
			if (e.getPassword().equals(password)) {
				return e;
			} else {
				return null;
			}
			
		}
		
		public int createRequest(Request request) throws SQLException {
		int count=0;
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			connection.setAutoCommit(false);
			
			count = eDao.createRequest(request);
			
			connection.commit();
			
	} catch (SQLException e) {
	
}
	
return count;
	
	

}
	
		
		

}







