package com.brockton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Employee;
import com.brockton.util.ConnectionUtil;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {
	private static Logger log=Logger.getLogger(EmployeeLoginDAOImpl.class);

	public EmployeeLoginDAOImpl() {
		
	}
	
	
	public Employee lookforUNPW(String userName, String passWord) throws DatabaseConnectionException {
		Employee employee = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM banking_1.employee_un WHERE (employee_un.un=? AND employee_un.password_1=?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,  userName);
			pstmt.setString(2, passWord);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String userName1 = rs.getString("un");
				String passWord1 = rs.getString("password_1");
				
				employee = new Employee(userName1, passWord1);
			}
			
			
		} catch (SQLException e) {
			
		}
		
		return employee;
	}

}
