package com.brockton.model;

public class Account {

		private int id;
		private int accountNumber;
		private String accountType;
		private int startingBalance;
		private int balance;
		private int customerId;
		private int pendingTransferAN;
		private int transferAmount;
		
		
		public Account() {
			super();
		}
		
public Account (int id, int accountNumber, String accountType, int startingBalance, int balance, int customerId, int pendingTransferAN, int transferAmount) {
	
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.startingBalance = startingBalance;
		this.balance = balance;
		this.customerId = customerId;
		this.pendingTransferAN = pendingTransferAN;
		this.transferAmount = transferAmount;
		
}
public Account (int id) {
	this.id = id;


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

public int getPendingTransferAN() {
	return pendingTransferAN;
}

public void setPendingTransferAN(int pendingTransferAN) {
	this.pendingTransferAN = pendingTransferAN;
}

public int getTransferAmount() {
	return transferAmount;
}

public void setTransferAmount(int transferAmount) {
	this.transferAmount = transferAmount;
}

@Override
public String toString() {
	return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
			+ ", startingBalance=" + startingBalance + ", balance=" + balance + ", customerId=" + customerId
			+ ", pendingTransferAN=" + pendingTransferAN + ", transferAmount=" + transferAmount + "]";
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
	result = prime * result + pendingTransferAN;
	result = prime * result + startingBalance;
	result = prime * result + transferAmount;
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
	if (pendingTransferAN != other.pendingTransferAN)
		return false;
	if (startingBalance != other.startingBalance)
		return false;
	if (transferAmount != other.transferAmount)
		return false;
	return true;
}




//public Account (int customerId) { 
//	this.customerId = customerId;  
//}








}