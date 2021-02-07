package com.brockton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.CustomerNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Customer;
import com.brockton.util.ConnectionUtil;

public class CustomerLoginDAOImp implements CustomerLoginDAO {
	private static Logger log=Logger.getLogger(CustomerLoginDAOImp.class);
	
	


	
	public Customer lookforUNandPW(String userName, String passWord) throws DatabaseConnectionException   {
		Customer customer = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM banking_1.customer_un WHERE (customer_un.user_name=? AND customer_un.password_1=?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String userName1 = rs.getString("user_name");
				String passWord1 = rs.getString("password_1");
				
				customer = new Customer(userName1, passWord1);
				
			}
			
			
		} catch (SQLException e) {
			
		}
		
		return customer;
	}

}
