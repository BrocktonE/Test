package com.brockton.services;

import org.apache.log4j.Logger;

import com.brockton.dao.ActionDAO;
import com.brockton.dao.ActionDAOImpl;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;

public class ApproveService {
	private static Logger log=Logger.getLogger(ApproveService.class);

	
		ActionDAO actionDAO;
		
		public ApproveService() {
			actionDAO = new ActionDAOImpl();
		}
		
		public Application approveAccount(int id, String approve) throws DatabaseConnectionException {
			actionDAO.approveAccount(id, approve);
			return null;
		
	}

}

