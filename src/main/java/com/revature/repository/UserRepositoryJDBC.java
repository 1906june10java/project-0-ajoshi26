package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.model.Account;
//import com.revature.model.Hero;
//import com.revature.model.Universe;
import com.revature.util.BankConnectionUtil;

public class UserRepositoryJDBC implements UserRepository{

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);
	
	@Override
	public boolean createUser(User user) {
		LOGGER.trace("Entering create method with parameter: " + user);
		
		try(Connection connection = BankConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String query = "INSERT INTO UserTable VALUES (?, ?, ?)";
			
			PreparedStatement UserStatement = connection.prepareStatement(query);
			
			UserStatement.setString(++parameterIndex,user.getUserID());
			UserStatement.setString(++parameterIndex, user.getUserPassword());
			UserStatement.setLong(++parameterIndex, user.getAccount().getAccountNumber());
			
			if(UserStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(SQLException e) {
			LOGGER.error("Could not create user account.", e);
		}
		
		
		return false;
	}

	@Override
	public boolean findIDandPassword(String id, String password) {
		LOGGER.trace("Finding ID and password");

		try(Connection connection = BankConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String sql = "SELECT * FROM UserTable WHERE USER_ID = ? AND USER_PASSWORD = ?";

			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setString(++parameterIndex, id);
			UserStatement.setString(++parameterIndex, password);
			
			ResultSet result = UserStatement.executeQuery();
			
			if(result.next()) {
				LOGGER.trace("Found ID and Password");
				return true;
			}

		}catch(SQLException e) {
			LOGGER.error("Could not find User Password.", e);
		}
		
		
		return false;
	}

//	@Override
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepositoryJDBC();
		//userRepository.createUser(new User("bob","aser253",12312,new Account(2342,12312,50.00)));
		LOGGER.info(userRepository.findIDandPassword("ajoshi26", "1234"));
		
		
		
	}
}
