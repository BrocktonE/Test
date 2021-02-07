package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.brockton.dao.ActionDAO;
import com.brockton.dao.ActionDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;
import com.brockton.util.ConnectionUtil;

public class PullApplicationService {
	private static Logger log=Logger.getLogger(PullApplicationService.class);

	public ActionDAO actionDAO;
	
	public PullApplicationService() {
		actionDAO = new ActionDAOImpl();
			
	}
	public List<Application> getApplications() throws DatabaseConnectionException, AccountNotFoundException {
	List applicationList = actionDAO.getApplications();
	
	if (applicationList !=null) {
		for(int i = 0; i<applicationList.size(); i++) {
			System.out.println(applicationList.get(i));	
		}
		return applicationList;
	} else {
		throw new AccountNotFoundException("Applications not found");
	}
		
			
		
//	List application = null;
		
//		try (Connection connection = ConnectionUtil.getConnection()) {
			
//	connection.setAutoCommit(false);
	//deleteList<Application>		
//	application = actionDAO.getApplications();
//		connection.commit();
			
//		} catch (SQLException|DatabaseConnectionException e) {
//			System.out.println(e.getMessage());
//		}
	//	<return application>
//		return application;
	}

}
