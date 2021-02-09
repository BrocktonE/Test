package com.brockton.dao;


import java.sql.SQLException;

import com.brockton.model.Customer;

public interface CustomerDAO {
	
	public int createCustomerUnPw(Customer customer) throws SQLException;

}
