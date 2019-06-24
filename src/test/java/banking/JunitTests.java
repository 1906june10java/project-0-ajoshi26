package banking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC;
import com.revature.exception.*;

public class JunitTests {
	
	@Rule
	private static final UserRepositoryJDBC testUser = new UserRepositoryJDBC();
	private static final AccountRepositoryJDBC testAccount = new AccountRepositoryJDBC();
	
	
	@Test
	public void withdraw() {
		final String username = "ajoshi26";
		final String password = "1234";
		assertTrue(testUser.findIDandPassword(username, password));
		
	}
	
	
	
	@Test
	public void deposit() {
		final double amount = 40;
		assertTrue(testAccount.depositMoney(amount));
		
	}
	
	

}
