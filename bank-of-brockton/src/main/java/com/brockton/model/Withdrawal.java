package com.brockton.model;

public class Withdrawal {
	
	private int id;
	private int accountNumber;
	private String accountType;
	private int startingBalance;
	private int balance;
	private int customerId;

	
	public Withdrawal() {
		super();
		
	}

	public Withdrawal(int id, int accountNumber, String accountType, int startingBalance, int balance, int customerId) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.startingBalance = startingBalance;
		this.balance = balance;
		this.customerId = customerId;
		
	}
	public Withdrawal(int accountNumber, String accountType, int startingBalance, int balance, int customerId) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.startingBalance = startingBalance;
		this.balance = balance;
		this.customerId = customerId;
	}	
	public Withdrawal(int accountNumber) {
	this.accountNumber = accountNumber;
	
}
	public Withdrawal(int accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(int startingBalance) {
		this.startingBalance = startingBalance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Withdrawal [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", startingBalance=" + startingBalance + ", balance=" + balance + ", customerId=" + customerId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + balance;
		result = prime * result + customerId;
		result = prime * result + id;
		result = prime * result + startingBalance;
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
		Withdrawal other = (Withdrawal) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (balance != other.balance)
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (startingBalance != other.startingBalance)
			return false;
		return true;
	}



}