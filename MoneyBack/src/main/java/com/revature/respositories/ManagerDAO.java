package com.revature.respositories;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Approve;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseR;
import com.revature.models.Request;

public interface ManagerDAO {
	
	
	public int approve(Approve approve) throws SQLException;
	public List<Reimburse> findAll();
	public List<ReimburseR> findAllR();

}

	
