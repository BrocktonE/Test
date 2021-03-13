package com.revature.models;

public class Approve {
	
	private int id; // = resolver id
	private int status;
	private int requestId;  // = request id 
	
	
	public Approve() {
		
	}
	
	public Approve(int id, int status, int requestId) {
		super();
		this.id = id;
		this.status = status;
		this.requestId = requestId;
		
			
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Approve [requestId=" + requestId + ", id=" + id + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + requestId;
		result = prime * result + status;
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
		Approve other = (Approve) obj;
		if (id != other.id)
			return false;
		if (requestId != other.requestId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}