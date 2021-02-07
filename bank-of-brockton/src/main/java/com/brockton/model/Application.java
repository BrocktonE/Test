package com.brockton.model;

public class Application {

	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String accountType;
	private int initialDeposit;
	private String approved;
	
	public Application() {
		super();
	

	}
	
public Application(int id, String userName, String firstName, String lastName, String accountType, int initialDeposit, String approved) {
	
	this.id = id;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.accountType = accountType;
	this.initialDeposit = initialDeposit;
	this.approved = approved;
}

public Application(String userName, String firstName, String lastName, String accountType, int initialDeposit) {
	
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.accountType = accountType;
	this.initialDeposit = initialDeposit;


}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

public int getInitialDeposit() {
	return initialDeposit;
}

public void setInitialDeposit(int initialDeposit) {
	this.initialDeposit = initialDeposit;
}

public String getApproved() {
	return approved;
}

public void setApproved(String approved) {
	this.approved = approved;
}

@Override
public String toString() {
	return "Application [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", accountType=" + accountType + ", initialDeposit=" + initialDeposit + ", approved=" + approved + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
	result = prime * result + ((approved == null) ? 0 : approved.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + initialDeposit;
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
	Application other = (Application) obj;
	if (accountType == null) {
		if (other.accountType != null)
			return false;
	} else if (!accountType.equals(other.accountType))
		return false;
	if (approved == null) {
		if (other.approved != null)
			return false;
	} else if (!approved.equals(other.approved))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (initialDeposit != other.initialDeposit)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}



}
