package com.brockton.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Account;
import com.brockton.model.AccountNumber;
import com.brockton.model.Application;

import com.brockton.model.Withdrawal;
import com.brockton.util.ConnectionUtil;


public class AccountDAOImpl implements AccountDAO {

	private static Logger log = Logger.getLogger(AccountDAOImpl.class);

	public AccountDAOImpl() {
		super();
	}
	
	@Override
	public int createApplication(Application application) throws SQLException, DatabaseConnectionException {
		int count = 0;
		try (Connection connection = ConnectionUtil.getConnection()) {

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
			
		}
		return count;

	}

	@Override
	public Withdrawal getBalance(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		Withdrawal balance = null;
		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "SELECT transfer_amount, balance FROM banking_1.accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				balance = new Withdrawal();
				balance.setTransferAmount(rs.getInt("transfer_amount"));
				balance.setBalance(rs.getInt("balance"));
				

			} else {
				
			}

		} catch (SQLException | DatabaseConnectionException e) {
		
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
	
	public int makeDeposit(int accountNumber, int deposit) throws DatabaseConnectionException, AccountNotFoundException  {
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
		
		}

		return 0;

	}

	@Override
	public int transfer(Account account) throws SQLException, DatabaseConnectionException, AccountNotFoundException {
		int count = 0;
		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "UPDATE banking_1.accounts SET transfer_amount=?, pending_transfer=? WHERE banking_1.accounts.account_number=?;"
					+ "UPDATE banking_1.accounts SET transfer_amount=?, from_transfer=? WHERE banking_1.accounts.account_number=?;"
					+"INSERT INTO banking_1.transactions (transaction_type, amount, account_number)"
					+ "	VALUES('transferfrom',?,?);"
					+"INSERT INTO banking_1.transactions (transaction_type, amount, account_number)"
					+ "VALUES('transfertoo', ?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, account.getTransferAmount());
			preparedStatement.setInt(2, account.getAccountNumber());
			preparedStatement.setInt(3, account.getPendingTransferAN());
			preparedStatement.setInt(4, account.getTransferAmount());
			preparedStatement.setInt(5, account.getAccountNumber());
			preparedStatement.setInt(6, account.getAccountNumber());
			preparedStatement.setInt(7, account.getTransferAmount());
			preparedStatement.setInt(8, account.getAccountNumber());
			preparedStatement.setInt(9, account.getTransferAmount());
			preparedStatement.setInt(10, account.getPendingTransferAN());
			

			count = preparedStatement.executeUpdate();

		} catch (SQLException | DatabaseConnectionException e) {
			log.error("Problem with SQL");
			log.error(e.getMessage());
		}
		return count;

	}

	@Override
	public int giveTransfer(int accountNumberG, int accountNumberR) throws DatabaseConnectionException, AccountNotFoundException {
		int count = 0;
		try(Connection connection = ConnectionUtil.getConnection()) {
			connection.setAutoCommit(false);
			
			String sql = "UPDATE banking_1.accounts SET balance = (balance - transfer_amount) WHERE banking_1.accounts.account_number = ?";								
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setInt(1, accountNumberG);	
			count = preparedStatement.executeUpdate();
			System.out.println(count);
			
			String sql4 = "UPDATE banking_1.accounts SET transfer_amount=0, from_transfer=0 WHERE banking_1.accounts.account_number=?";
			PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
			preparedStatement4.setInt(1, accountNumberG);
			count = preparedStatement4.executeUpdate();
			System.out.println(count);
			
			String sql2 = "UPDATE banking_1.accounts SET balance = (balance + transfer_amount) WHERE banking_1.accounts.account_number = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, accountNumberR);	
			count = preparedStatement2.executeUpdate();
			System.out.println(count);
			
			
			String sql3 = "UPDATE banking_1.accounts SET transfer_amount=0, pending_transfer=0 WHERE banking_1.accounts.account_number=?";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, accountNumberR);
			count = preparedStatement3.executeUpdate();
		
			connection.commit();
					
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return count;
		

 }

	@Override
	public int completeTransfer(int accountNumberR) throws DatabaseConnectionException {
		int count = 0;
		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "UPDATE banking_1.accounts SET balance = (balance + transfer_amount) WHERE banking_1.accounts.account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, accountNumberR);

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	@Override
	public int makeWithdrawal(int accountNumber, int withdrawal) throws DatabaseConnectionException, AccountNotFoundException {
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
			
		}

		return 0;

	}

	@Override
	public Withdrawal getUNandPW(int accountNumber) throws DatabaseConnectionException, AccountNotFoundException {
		Withdrawal account = null;
		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "SELECT customer_un, customer_pw FROM banking_1.accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				account = new Withdrawal();
				account.setCustomerUN(rs.getString("customer_un"));
				account.setCustomerPW(rs.getString("customer_pw"));

			} else {
			//	throw new AccountNotFoundException("Account Number: " + accountNumber + "was not found");
			}

		} catch (SQLException e ) {
			
		}

		return account;
	

	}

//	@Override
//	public int removeTransfer(int accountNumberG, int accountNumberR) throws SQLException {
//		int count = 0;
//		try (Connection connection = ConnectionUtil.getConnection()) {
//
//			String sql = "UPDATE banking_1.accounts SET transfer_amount=0, pending_transfer=0 WHERE banking_1.accounts.account_number=?;"
//					+ "UPDATE banking_1.accounts SET transfer_amount=0, from_transfer=0 WHERE banking_1.accounts.account_number=?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//			preparedStatement.setInt(1, accountNumberR);
//			preparedStatement.setInt(2, accountNumberG);
//
//			count = preparedStatement.executeUpdate();
//
//		} catch (SQLException | DatabaseConnectionException e) {
//			log.error(e.getMessage());
//		}
//	return count;

//	}
	@Override
	public int getPendingTransfer(int accountNumber) throws AccountNotFoundException, DatabaseConnectionException {
		int accountNumberG = 0;
		try (Connection connection = ConnectionUtil.getConnection()) {

			String sql = "SELECT pending_transfer FROM banking_1.accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				 accountNumberG = rs.getInt("pending_transfer");
				

			} else {
				throw new AccountNotFoundException("Account Number: " + accountNumber + "was not found");
				
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
		}

		return accountNumberG;
	
}


}
