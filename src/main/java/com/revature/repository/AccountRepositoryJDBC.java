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

public class AccountRepositoryJDBC implements AccountRepository{

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);
	
	@Override
	public Account lookAccount(long account) {
		
		
		LOGGER.trace("Finding account");

		try(Connection connection = BankConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String sql = "SELECT * FROM AccountTable WHERE ACCOUNT_ID = ?";

			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setLong(++parameterIndex, account);
			ResultSet result = UserStatement.executeQuery();
			boolean returned = result.next();
			System.out.println(returned);
			if(returned) {
				LOGGER.info("Account found!");
				return new Account(
							result.getLong("ACCOUNT_ID"),
							result.getLong("ACCOUNT_NUMBER"),
							result.getDouble("CURRENT_BALANCE")
							);
			}

		}catch(SQLException e) {
			LOGGER.error("Could not find account.", e);
		}
		
		return null;
	}

	@Override
	public boolean depositMoney(double amount) {
		LOGGER.trace("Deposit money into account");
		

		try(Connection connection = BankConnectionUtil.getConnection()){
			
			int parameterIndex = 0;
			String sql = "UPDATE AccountTable SET CURRENT_BALANCE = (CURRENT_BALANCE + ?)";
			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setDouble(++parameterIndex, amount);
			ResultSet result = UserStatement.executeQuery();
			
			//connection.commit();
			
		}catch(SQLException e) {
			LOGGER.error("Could not find deposit money.", e);
		}
		
		return true;
	}

	@Override
	public boolean withdrawMoney(double amount) {
		LOGGER.trace("Withdrawing money into account");

		try(Connection connection = BankConnectionUtil.getConnection()){
			
			int parameterIndex = 0;
			String sql = "UPDATE AccountTable SET CURRENT_BALANCE = (CURRENT_BALANCE - ?)";
			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setDouble(++parameterIndex, amount);
			ResultSet result = UserStatement.executeQuery();
			
			//connection.commit();
			
			
		}catch(SQLException e) {
			LOGGER.error("Could not find withdraw money.", e);
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		AccountRepository accRepo = new AccountRepositoryJDBC();
//		LOGGER.info(accRepo.lookAccount(3224));
//	}

}
