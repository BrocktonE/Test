package com.revature.respositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Approve;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseR;
import com.revature.util.ConnectionUtil;

import jdk.internal.org.jline.utils.Log;

public class ManagerDAOImpl implements ManagerDAO {
	
	private static Logger log = Logger.getLogger(ManagerDAOImpl.class);

	@Override
	public int approve(Approve approve) throws SQLException {
		
		int count = 0;
		try  {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE brocktone.ers_reimbursement SET reimb_resolved = current_timestamp, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?" ;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, approve.getId());
			preparedStatement.setInt(2, approve.getStatus());
			preparedStatement.setInt(3, approve.getRequestId());

			count = preparedStatement.executeUpdate();
		} catch (SQLException  e) {
			
		}
		return count;
	}

	@Override
	public List<Reimburse> findAll() {
		
		List<Reimburse> list = new ArrayList<Reimburse>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			 
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				double amount  = rs.getDouble("reimb_amount");
				String description = rs.getString("reimb_description");
				int author = rs.getInt("reimb_author");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				Reimburse r = new Reimburse(id, amount, description, author, status, type);
				list.add(r);
				
				System.out.println(r);
				
				
			}
		
		
	} catch (SQLException e) {
		log.warn(e);
	}
		
	return list;
	}

	@Override
	public List<ReimburseR> findAllR() {
List<ReimburseR> list = new ArrayList<ReimburseR>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 2";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
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
	
	
	
	
	
	
	