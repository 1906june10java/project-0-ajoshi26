package com.revature.model;

public class Account {
	
	private long AccountID;
	private long AccountNumber;
	private double balance;
	
	public Account() {}

	public Account(long accountID, long accountNumber, double balance) {
		//super();
		AccountID = accountID;
		AccountNumber = accountNumber;
		this.balance = balance;
	}
	

	public long getAccountID() {
		return AccountID;
	}

	public void setAccountID(long accountID) {
		AccountID = accountID;
	}

	public long getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (AccountID ^ (AccountID >>> 32));
		result = prime * result + (int) (AccountNumber ^ (AccountNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (AccountID != other.AccountID)
			return false;
		if (AccountNumber != other.AccountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [AccountID=" + AccountID + ", AccountNumber=" + AccountNumber + ", balance=" + balance + "]";
	}

	
	
	
}