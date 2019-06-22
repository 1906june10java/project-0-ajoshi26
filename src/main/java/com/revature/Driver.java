package com.revature;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.UserRepositoryJDBC; 

public class Driver {
	
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		UserRepositoryJDBC user = new UserRepositoryJDBC();
		//Account account = new Account();
		
		while(true) {
			System.out.println("Welcome to Bank Joshi!");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");

			switch(input.next()) {
			case "1":
				System.out.println("Enter in username: ");
				String username = input.next();
				System.out.println("Enter in password: ");
				String password = input.next();

				if(user.findIDandPassword(username, password)) {
					System.out.println("Login Successful!");

				}
				else {
					System.out.println("Login Invalid!");

				}

				break;
			case "2":
				System.out.println("Create a username: ");
				String newUsername = input.next();
				System.out.println("Create a password: ");
				String newPassword = input.next();
				System.out.println("Create an account number: ");

				long newAccountNumber = input.nextLong();
				double newBalance = 0.00;
				Account newAccount = new Account(newAccountNumber,newAccountNumber,newBalance);
				User newUser = new User(newUsername,newPassword,newAccount);


				if(user.createUser(newUser)) {
					System.out.println("New account created");
				}
				else {
					System.out.println("Creation Invalid!");
				}
				break;
			case "3":
				System.out.println("Have a nice day!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!");

			}
		}
		
		
	}
}
	

