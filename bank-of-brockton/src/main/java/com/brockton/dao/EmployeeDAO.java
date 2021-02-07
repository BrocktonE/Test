package com.brockton.dao;

import java.sql.SQLException;

import com.brockton.model.Employee;

public interface EmployeeDAO {
	
	public int createEmployeeUnPw(Employee employee) throws SQLException;

}
