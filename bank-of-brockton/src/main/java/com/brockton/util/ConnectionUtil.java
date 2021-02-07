package com.brockton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.postgresql.Driver;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;

public class ConnectionUtil {
	private static Logger log=Logger.getLogger(ConnectionUtil.class);
	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() throws DatabaseConnectionException {
		Connection connection = null;
		
		try {
		DriverManager.registerDriver(new Driver());
		
		
		
		String url = System.getenv("db_url");
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");
		
		connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Connection Failed");
		}
		
		return connection;
		
	}

}
