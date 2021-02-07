package com.brockton.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Application;
import com.brockton.model.Transfer;
import com.brockton.model.Withdrawal;
import com.brockton.util.ConnectionUtil;


public class AccountDAOImpl implements AccountDAO {

	private static Logger log=Logger.getLogger(AccountDAOImpl.class);
	
	public AccountDAOImpl() {
		super();
	}

	@Override
	public int createApplication(Application application) throws SQLException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO banking_1.application (user_name, first_name, last_name, account_type, starting_balance) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, application.getUserName());
			preparedStatement.setString(2, application.getFirstName());
			preparedStatement.setString(3, application.getLastName());
			preparedStatement.setString(4, application.getAccountType());
			preparedStatement.setInt(5, application.getInitialDeposit());
			
			count = preparedStatement.executeUpdate();
		} catch (SQLException | DatabaseConnectionException e) {
			log.trace(e.getMessage());
		}
		return count;

}
	@Override
	public Withdrawal getBalance(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		Withdrawal balance = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT balance FROM banking_1.accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				balance = new Withdrawal();
				balance.setBalance(rs.getInt("balance"));
			
			} else {
				throw new AccountNotFoundException("Account Number: " + accountNumber + "was not found");
			}
			
		
			
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
		}
		
		return balance;
		
			
		}
		
		
		
		
		
	

//	@Override
//	public int makeWithdrawal(int accountNumber, int withdrawal) throws DatabaseConnectionException {
//		int count = 0;
//			try (Connection connection = ConnectionUtil.getConnection()) {

//				String sql = "UPDATE banking_1.accounts SET balance = (balance - ?) WHERE banking_1.accounts.account_number=?";
//				PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
//				preparedStatement.setInt(1, withdrawal);
//				preparedStatement.setInt(2, accountNumber);
				
//				count = preparedStatement.executeUpdate();
//			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
		
//			}

//			return 0;
		
//	}

	@Override
	public int makeDeposit(int accountNumber, int deposit) throws DatabaseConnectionException {
		int count = 0;
			try (Connection connection = ConnectionUtil.getConnection()) {

				String sql = "UPDATE banking_1.accounts SET balance = (balance + ?) WHERE banking_1.accounts.account_number=?;"
							+ "INSERT INTO banking_1.transactions (transaction_type, amount, account_number)"
							+ "VALUES('deposit',?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, deposit);
				preparedStatement.setInt(2, accountNumber);	
				preparedStatement.setInt(3, deposit);
				preparedStatement.setInt(4, accountNumber);
				
				count = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}

		return 0;
		
	}

	@Override
	public int transfer(Transfer transfer) throws SQLException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE banking_1.accounts SET transfer_amount=?, pending_transfer=? WHERE banking_1.accounts.account_number=?";
					
					
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transfer.getAmount());
			preparedStatement.setInt(2, transfer.getAccountNumber());
			preparedStatement.setInt(3, transfer.getToAccount());
			
			
			
			count = preparedStatement.executeUpdate();
			
		
			
			
		} catch (SQLException | DatabaseConnectionException e) {
			log.trace(e.getMessage());
		}
		return count;

}

	@Override
	public int completeTransfer(int accountNumber) throws DatabaseConnectionException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE banking_1.accounts SET balance = (balance + transfer_amount) WHERE banking_1.accounts.account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, accountNumber);
			
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public int makeWithdrawal(int accountNumber, int withdrawal) throws DatabaseConnectionException {
		int count = 0;
			try (Connection connection = ConnectionUtil.getConnection()) {

				String sql = "UPDATE banking_1.accounts SET balance = (balance - ?) WHERE banking_1.accounts.account_number=?;"
								+ "INSERT INTO banking_1.transactions (transaction_type, amount, account_number)"
								+ "VALUES('withdraw',?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
				preparedStatement.setInt(1, withdrawal);
				preparedStatement.setInt(2, accountNumber);	
				preparedStatement.setInt(3, withdrawal);
				preparedStatement.setInt(4, accountNumber);
				
				count = preparedStatement.executeUpdate();
				
				
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}

			return 0;
	
	
	
			
}


}



