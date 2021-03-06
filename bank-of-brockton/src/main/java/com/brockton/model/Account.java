package com.brockton.model;

public  class Account {

		private int id;
		private int accountNumber;
		private String accountType;
		private int startingBalance;
		private int balance;
		private int customerId;
		private int fromTransferAN;
		private int pendingTransferAN;
		private int transferAmount;
		private String customerUN;
		private String customerPW;
		
		
		public Account() {
			super();
		}
		
	public Account (int id, int accountNumber, String accountType, int startingBalance, int balance, int customerId, int fromTransferAN, int pendingTransferAN, int transferAmount, String customerUN, String customerPW) {
	
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.startingBalance = startingBalance;
		this.balance = balance;
		this.customerId = customerId;
		this.fromTransferAN = fromTransferAN;
		this.pendingTransferAN = pendingTransferAN;
		this.transferAmount = transferAmount;
		this.customerUN = customerUN;
		this.customerPW = customerPW;
		
}

public Account (int id) {
	this.id = id;


}
public Account (int amount, int accountNumber, int pendingTransferAN) {
	this.transferAmount = amount;
	this.accountNumber = accountNumber;
	this.pendingTransferAN = pendingTransferAN;

}
public Account (String customerUN, String customerPW) {
	this.customerUN = customerUN;
	this.customerPW = customerPW;

}
//public Account (int accountNumber) {
//	this.accountNumber = accountNumber;

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

public int getFromTransferAN() {
	return fromTransferAN;
}

public void setFromTransferAN(int fromTransferAN) {
	this.fromTransferAN = fromTransferAN;
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

public String getCustomerUN() {
	return customerUN;
}

public void setCustomerUN(String customerUN) {
	this.customerUN = customerUN;
}

public String getCustomerPW() {
	return customerPW;
}

public void setCustomerPW(String customerPW) {
	this.customerPW = customerPW;
}

@Override
public String toString() {
	return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
			+ ", startingBalance=" + startingBalance + ", balance=" + balance + ", customerId=" + customerId
			+ ", fromTransferAN=" + fromTransferAN + ", pendingTransferAN=" + pendingTransferAN + ", transferAmount="
			+ transferAmount + ", customerUN=" + customerUN + ", customerPW=" + customerPW + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountNumber;
	result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
	result = prime * result + balance;
	result = prime * result + customerId;
	result = prime * result + ((customerPW == null) ? 0 : customerPW.hashCode());
	result = prime * result + ((customerUN == null) ? 0 : customerUN.hashCode());
	result = prime * result + fromTransferAN;
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
	if (customerPW == null) {
		if (other.customerPW != null)
			return false;
	} else if (!customerPW.equals(other.customerPW))
		return false;
	if (customerUN == null) {
		if (other.customerUN != null)
			return false;
	} else if (!customerUN.equals(other.customerUN))
		return false;
	if (fromTransferAN != other.fromTransferAN)
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

//}

}