package com.revature;

import java.util.Scanner;

//import com.revature.exception.InputValidationException;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC; 
import com.revature.exception.*;

public class Driver {
	
	public static void main(String [] args) throws WithdrawalAmountException, DepositAmount {
		
		Scanner input = new Scanner(System.in);
		UserRepositoryJDBC user = new UserRepositoryJDBC();
		AccountRepositoryJDBC account = new AccountRepositoryJDBC();
		WithdrawalAmountException withdrawalAmount = new WithdrawalAmountException();
		DepositAmount deposit = new DepositAmount();
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
						System.out.println("Enter in account number:");
						accountNum = input.nextLong();
						System.out.println("Enter in the amount you would like to deposit:");
						double amount = input.nextDouble();
						
						if(deposit.DepositAmount(amount)) {
							if(account.depositMoney(amount)) {
								System.out.println("You have successfully withdrawn money!");
							}
						}
						else {
							throw new DepositAmount();
						}
						break;
					case 2:
						System.out.println("Enter in account number:");
						accountNum = input.nextLong();
						System.out.println("Enter in the amount you would like to withdraw:");
						amount = input.nextDouble();
						
						if(withdrawalAmount.WithdrawalAmountException(amount, account.getBalanceAmount(accountNum))) {
							if(account.withdrawMoney(amount)) {
								System.out.println("You have successfully withdrawn money!");
							}
						}
						else {
							//Throw InputValidation exception
							throw new WithdrawalAmountException();
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
					//throw new InputValidationException(username, password);
					System.out.println("Invalid Login!");
				}

				break;
			case "2":
				System.out.println("Have a nice day!");
				System.exit(0);
				break;
			default:
				

			}
		}
		
		
	}
}
	

