package com.revature.models;

public class AuthorId {

	private int aid;

	public AuthorId() {
		super();
	}


	public AuthorId(int aid) {
		super();
		this.aid = aid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "AuthorId [aid=" + aid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
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
		AuthorId other = (AuthorId) obj;
		if (aid != other.aid)
			return false;
		return true;
	}

}