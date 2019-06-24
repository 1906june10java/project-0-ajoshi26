package com.revature.exception;

public class DepositAmount extends Exception {
	
	public boolean DepositAmount(double amount) {
		
		if(amount > 0) {
			return true;
		}
		
		return false;
		
	}
}
