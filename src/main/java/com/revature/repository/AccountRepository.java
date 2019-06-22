package com.revature.repository;

import java.sql.Connection;
//import java.util.List;

import com.revature.model.Account;
import com.revature.util.BankConnectionUtil;

public interface AccountRepository {
	
	public Account lookAccount(long account);
	public boolean depositMoney(double amount);
	public boolean withdrawMoney(double amount);
	
}
