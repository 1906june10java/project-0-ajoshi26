package com.revature.exception;

public class InputValidationException extends Exception {
	
	public InputValidationException(String username, String password)
	{
		super("The username and password you entered is invalid");
	}
	
}
