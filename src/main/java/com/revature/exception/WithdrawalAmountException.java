package com.revature.exception;

public class WithdrawalAmountException extends Exception{
	
	public boolean WithdrawalAmountException(double amount, double balance) {
		
		if (amount < balance) {
			return true;
		}
		
		return false;
	}
}
