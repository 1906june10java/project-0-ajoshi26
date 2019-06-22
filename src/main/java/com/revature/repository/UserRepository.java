package com.revature.repository;
import java.sql.Connection;
import java.util.List;

import com.revature.model.User;
import com.revature.util.BankConnectionUtil;

public interface UserRepository {
	
	public boolean createUser(User user);
	public boolean findIDandPassword(String id, String password);
	
}
