package com.brockton.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.util.ConnectionUtil;

public class Transfer {

	private int id;
	private int accountNumber;
	private int toAccount;
	private int amount;
	
	
	public Transfer() {
		super();
	}



public Transfer(int id, int accountNumber, int toAccount, int amount) {
	
	this.id = id;
	this.accountNumber = accountNumber;
	this.toAccount = toAccount;
	this.amount = amount;
}

public Transfer( int amount, int accountNumber, int toAccount) {
	
	this.amount = amount;
	this.accountNumber = accountNumber;	
	this.toAccount = toAccount;
	
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



public int getToAccount() {
	return toAccount;
}



public void setToAccount(int toAccount) {
	this.toAccount = toAccount;
}



public int getAmount() {
	return amount;
}



public void setAmount(int amount) {
	this.amount = amount;
}



@Override
public String toString() {
	return "Transfer [id=" + id + ", accountNumber=" + accountNumber + ", toAccount=" + toAccount + ", amount=" + amount
			+ "]";
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountNumber;
	result = prime * result + amount;
	result = prime * result + id;
	result = prime * result + toAccount;
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
	Transfer other = (Transfer) obj;
	if (accountNumber != other.accountNumber)
		return false;
	if (amount != other.amount)
		return false;
	if (id != other.id)
		return false;
	if (toAccount != other.toAccount)
		return false;
	return true;
}






}

