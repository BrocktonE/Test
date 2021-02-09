package com.brockton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Customer;
import com.brockton.util.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);
	
	public CustomerDAOImpl() {
		super();
	}

	@Override
	public int createCustomerUnPw(Customer customer) throws SQLException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
				
			String sql = "INSERT INTO banking_1.customer_un (user_name, password_1) "
					+ "VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getUserName());
			preparedStatement.setString(2, customer.getPassWord());
			
			
	count = preparedStatement.executeUpdate();
				
			
		} catch (SQLException | DatabaseConnectionException e)	 {
			log.trace(e.getMessage());
		}
		
	
		
		return count;
	}

}
