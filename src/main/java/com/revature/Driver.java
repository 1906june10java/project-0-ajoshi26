package com.revature;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC; 

public class Driver {
	
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		UserRepositoryJDBC user = new UserRepositoryJDBC();
		AccountRepositoryJDBC account = new AccountRepositoryJDBC();
		long accountNum = 0;
		//Account account = new Account();
		
		while(true) {
			System.out.println("Welcome to Bank Joshi!");
			System.out.println("1. Login");
			System.out.println("2. Exit");

			switch(input.next()) {
			case "1":
				System.out.println("Enter in username: ");
				String username = input.next();
				System.out.println("Enter in password: ");
				String password = input.next();

				if(user.findIDandPassword(username, password)) {
					System.out.println("Login Successful!");
					
					System.out.println("What would you like to do today?");
					System.out.println("1. Deposit Money");
					System.out.println("2. Withdraw Money");
					System.out.println("3. View Balance");
					
					int choice = input.nextInt();
					
					switch(choice) {
					case 1:
//						System.out.println("Enter in account number:");
//						accountNum = input.nextLong();
						System.out.println("Enter in the amount you would like to deposit:");
						double amount = input.nextDouble();
						if(account.depositMoney(amount)) {
							System.out.println("You have successfully deposited money!");
						}
						else {
							System.out.println("Something is wrong!");
						}
						break;
					case 2:
//						System.out.println("Enter in account number:");
//						accountNum = input.nextLong();
						System.out.println("Enter in the amount you would like to withdraw:");
						amount = input.nextDouble();
						if(account.withdrawMoney(amount)) {
							System.out.println("You have successfully withdrawn money!");
						}
						else {
							System.out.println("Something is wrong!");
						}
						break;
					case 3:
						System.out.println("Enter in your account number:");
						accountNum = input.nextLong();
						System.out.println(account.lookAccount(accountNum));
						break;
					default:
						break;
					}

				}
				else {
					System.out.println("Login Invalid!");

				}

				break;
			case "2":
				System.out.println("Have a nice day!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!");

			}
		}
		
		
	}
}
	

