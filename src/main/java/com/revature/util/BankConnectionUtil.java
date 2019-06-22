package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class BankConnectionUtil {
	
	private static final Logger logger = Logger.getLogger(BankConnectionUtil.class);
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@firstinstance.cyhmny1cgean.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "ajoshi97";
		String password = "Mangya0304!!";
		
		return DriverManager.getConnection(url,username,password);
		
		
	}
	
	public static void main(String[] args) {
		try {
			getConnection();
			logger.info("Connection successful");
		} catch (SQLException e) {
			logger.error("Could not connect.", e);
		}
	}
	
	

}
