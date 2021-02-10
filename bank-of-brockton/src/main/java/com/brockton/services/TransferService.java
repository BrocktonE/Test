package com.brockton.services;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.brockton.dao.AccountDAO;
import com.brockton.dao.AccountDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.util.ConnectionUtil;

public class TransferService {
	private static Logger log=Logger.getLogger(TransferService.class);

	public AccountDAO accountDAO;
	
	public TransferService() {
		accountDAO = new AccountDAOImpl();
		
}
public int transfer(Account account)	{
	int count = 0;
	
	try (Connection connection = ConnectionUtil.getConnection()) {
		
			connection.setAutoCommit(false);
			
			count = accountDAO.transfer(account);
			
			connection.commit();
			
	} catch (SQLException | DatabaseConnectionException e) {
		log.error(e.getMessage());
}
	
return count;
	
	

}


}