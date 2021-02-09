package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;
import com.brockton.util.ConnectionUtil;

public class ApplicationService {
	private static Logger log=Logger.getLogger(ApplicationService.class);

		public AccountDAO accountDAO;
		
		public ApplicationService() {
			accountDAO = new AccountDAOImpl();
			
	}
	public int createApplication(Application application)	{
		int count = 0;
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
				connection.setAutoCommit(false);
				
				count = accountDAO.createApplication(application);
				
				connection.commit();
				
		} catch (SQLException | DatabaseConnectionException e) {
			log.trace(e.getMessage());
	}
		
	return count;
		
		
	
	}
	

}
