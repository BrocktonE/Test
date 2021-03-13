package com.revature.respositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.AuthorId;
import com.revature.models.Employee;
import com.revature.models.ReimburseR;
import com.revature.models.Request;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	public boolean insert(Employee e) {
		
		
		PreparedStatement stmt = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) " + 
							"VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getUsername());
			stmt.setString(2, e.getPassword());
			stmt.setString(3, e.getFirstName());
			stmt.setString(4, e.getLastName());
			stmt.setString(5, e.geteMail());
			stmt.setInt(6, e.getUserRole());
			
			if (!stmt.execute()) {
				return false;
			}
				
			
		} catch (SQLException ex) {
			log.warn("Unable to inser user", ex);
			return false;
		} 
		
		return true;
	}

	public boolean update(Employee e) {
		
		return false;
	}

	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_users";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ers_users_id");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String eMail = rs.getString("user_email");
				int userRole = rs.getInt("user_role_id");
				
				Employee e = new Employee(id, username, password, firstName, lastName, eMail, userRole);
				list.add(e);
				
			}
			
		
				
			
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);
		
		} 
		
		return list;
	}

	@Override
	public int createRequest(Request request) throws SQLException {
		int count = 0;
		try  {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO brocktone.ers_reimbursement (reimb_amount, reimb_description, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id) "
					+ "VALUES (?, ?, current_timestamp, ?, 1, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, request.getAmount());
			preparedStatement.setString(2, request.getDescription());
			preparedStatement.setInt(3, request.getAuthor());
			preparedStatement.setInt(4, request.getType());

			count = preparedStatement.executeUpdate();
		} catch (SQLException  e) {
			
		}
		return count;
	}
	
	@Override
	public List<ReimburseR> findAllR(int authorId) {
List<ReimburseR> list = new ArrayList<ReimburseR>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 AND reimb_author = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, authorId);
			ResultSet rs = stmt.executeQuery();
			 
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				double amount  = rs.getDouble("reimb_amount");
				String description = rs.getString("reimb_description");
				int author = rs.getInt("reimb_author");
				int resolver = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				ReimburseR r = new ReimburseR(id, amount, description, author, resolver, status, type);
				list.add(r);
				
				System.out.println(r);
				
				
			}
		
		
	} catch (SQLException e) {
		log.warn(e);
	}
		
	return list;
	}
	
}
	
	
	

	
















