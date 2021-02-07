package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;
import com.brockton.model.Transfer;
import com.brockton.util.ConnectionUtil;

public class TransferService {
	private static Logger log=Logger.getLogger(TransferService.class);

	public AccountDAO accountDAO;
	
	public TransferService() {
		accountDAO = new AccountDAOImpl();
		
}
public int transfer(Transfer transfer)	{
	int count = 0;
	
	try (Connection connection = ConnectionUtil.getConnection()) {
		
			connection.setAutoCommit(false);
			
			count = accountDAO.transfer(transfer);
			
			connection.commit();
			
	} catch (SQLException | DatabaseConnectionException e) {
		log.trace(e.getMessage());
}
	
return count;
	
	

}


}