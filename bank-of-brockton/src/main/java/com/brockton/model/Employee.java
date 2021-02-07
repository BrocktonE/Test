package com.brockton.model;

public class Employee {
	
	private int id;
	private String userName;
	private String passWord;

	public Employee() {
		super();
	}
	
public Employee(int id, String userName, String passWord) {
	
	this.id = id;
	this.userName = userName;
	this.passWord = passWord;
	
}

public Employee(String userName, String passWord) {
	
	this.userName = userName;
	this.passWord = passWord;
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

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
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
	Employee other = (Employee) obj;
	if (id != other.id)
		return false;
	if (passWord == null) {
		if (other.passWord != null)
			return false;
	} else if (!passWord.equals(other.passWord))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}



}
