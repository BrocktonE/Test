package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Approve;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseR;
import com.revature.respositories.ManagerDAO;
import com.revature.respositories.ManagerDAOImpl;
import com.revature.util.ConnectionUtil;

public class ManagerService {
	public static ManagerDAO eDao = new ManagerDAOImpl();
	private static Logger log = Logger.getLogger(ManagerService.class);
	
	
	public static int approve(Approve approve) throws SQLException {
		int count=0;
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			connection.setAutoCommit(false);
			
			count = eDao.approve(approve);
			
			connection.commit();
			
		} catch (SQLException e) {
			
		}
		
		
		return count;
		
	
}
	
	public static List<Reimburse> findAll() {
		List reimbursementList = eDao.findAll();
		log.info(reimbursementList);
		
		if (reimbursementList !=null) {
			for(int i = 0; i<reimbursementList.size(); i++) {
				System.out.println(reimbursementList.get(i));
				
			}
			return reimbursementList;
		} else {
			return null;
		}
	}
	
	public static List<ReimburseR> findAllR() {
		List reimbursementListR = eDao.findAllR();
		log.info(reimbursementListR);
		
		if (reimbursementListR !=null) {
			for(int i = 0; i<reimbursementListR.size(); i++) {
				System.out.println(reimbursementListR.get(i));
				
			}
			return reimbursementListR;
		} else {
			return null;
		}
	}


}