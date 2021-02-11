package com.brockton.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.model.Application;
import com.brockton.model.Transactions;
import com.brockton.util.ConnectionUtil;

public class ActionDAOImpl implements ActionDAO {
	private static Logger log=Logger.getLogger(ActionDAOImpl.class);

	



	@Override
	public List<Application> getApplications() throws DatabaseConnectionException {
		List<Application> applicationList = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM banking_1.application";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs= preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				Application application = new Application();
				application.setId(rs.getInt("id"));
				application.setUserName(rs.getString("user_name"));
				application.setFirstName(rs.getString("first_name"));
				application.setLastName(rs.getString("last_name"));
				application.setAccountType(rs.getString("account_type"));
				application.setInitialDeposit(rs.getInt("starting_balance"));
				application.setApproved(rs.getString("approved"));
				
				
				applicationList.add(application);
				
					
	//			applicationList =  new ArrayList<>(applicationList);
			//	System.out.println(applicationList);	
			}
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
		}
		
		
		return applicationList;
	}

	@Override
	public int approveAccount(int id, String approve) throws DatabaseConnectionException {
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE banking_1.application SET approved = ? WHERE banking_1.application.id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, approve);
			preparedStatement.setInt(2, id);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Account> viewAccount(int customerId) throws DatabaseConnectionException, AccountNotFoundException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM banking_1.accounts WHERE accounts.customer_id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNumber(rs.getInt("account_number"));
				account.setAccountType(rs.getString("account_type"));
				account.setStartingBalance(rs.getInt("starting_balance"));
				account.setBalance(rs.getInt("balance"));
				account.setCustomerId(rs.getInt("customer_id"));
				account.setFromTransferAN(rs.getInt("from_transfer"));
				account.setPendingTransferAN(rs.getInt("pending_transfer"));
				account.setTransferAmount(rs.getInt("transfer_amount"));
				account.setCustomerUN(null);
				account.setCustomerPW(null);
				
			//	accountList = new Account(id, accountNumber, accountType, startingBalance, balance, customerId1, fromTransferAN, pendingTransferAN, transferAmount, customerUN, customerPW);
				accountList.add(account);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
	
		}

		return accountList;
	
	
	}

	@Override
	public List<Transactions> viewTransactions() throws DatabaseConnectionException {
		List<Transactions> transactionsList = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM banking_1.transactions";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs= preparedStatement.executeQuery();
			while (rs.next()) {
				Transactions transaction = new Transactions();
				transaction.setId(rs.getInt("id"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getInt("amount"));
				transaction.setAccountNumber(rs.getInt("account_number"));
			
				
				
				transactionsList.add(transaction);
			//	for(int i = <transactionsList.size(); i++) {
			//		System.out.println(transactionsList); {	
					
			//	}
					
				}
		}catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
		}
				return transactionsList;						
				
}
}
