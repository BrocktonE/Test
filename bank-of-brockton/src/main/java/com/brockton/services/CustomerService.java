package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAO;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.exceptions.InvalidUnPwException;
import com.brockton.model.Customer;
import com.brockton.util.ConnectionUtil;

public class CustomerService {
	private static Logger log=Logger.getLogger(CustomerService.class);
	
	public CustomerDAO customerDAO;

	public CustomerService() {
		customerDAO = new CustomerDAOImpl();
	
	}
	
	public int createCustomerUnPw(Customer customer) {
		int count = 0;
		
		
		try (Connection connection = ConnectionUtil.getConnection()) {
		
				connection.setAutoCommit(false);
		
				count = customerDAO.createCustomerUnPw(customer);
		
				connection.commit();
		
		} catch (SQLException | DatabaseConnectionException e) {
			log.trace(e.getMessage());
		}
		
	return count;
	}

}
