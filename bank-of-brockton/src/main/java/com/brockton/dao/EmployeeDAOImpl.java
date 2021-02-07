package com.brockton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Employee;
import com.brockton.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger log=Logger.getLogger(EmployeeDAOImpl.class);

	public EmployeeDAOImpl() {
		super();
		
	}

	@Override
	public int createEmployeeUnPw(Employee employee) throws SQLException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
				
			String sql = "INSERT INTO banking_1.employee_un (un, password_1) "
					+ "VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getPassWord());
			
			count = preparedStatement.executeUpdate();
			
		} catch (SQLException | DatabaseConnectionException e)  {
			log.trace(e.getMessage());
		}
		
		return count;
	}

}
