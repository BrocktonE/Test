package com.revature.respositories;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.AuthorId;
import com.revature.models.Employee;
import com.revature.models.ReimburseR;
import com.revature.models.Request;

public interface EmployeeDAO {
	
	public boolean insert(Employee e);
	//returns true if sucessfully inserted
	public boolean update(Employee e);
	
	public List<Employee> findAll();
	
	public List<ReimburseR> findAllR(int authorId);
	
	public int createRequest(Request request) throws SQLException;

}
