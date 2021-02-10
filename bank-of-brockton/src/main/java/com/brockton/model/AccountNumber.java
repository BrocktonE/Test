package com.brockton.model;

public class AccountNumber {
	
	private int pendingTransfer;
	
	public AccountNumber() {
		super();
	}



		public AccountNumber (int pendingTransfer) {
			this.pendingTransfer = pendingTransfer;
		}

		public int getPendingTransfer() {
			return pendingTransfer;
		}

		public void setPendingTransfer(int pendingTransfer) {
			this.pendingTransfer = pendingTransfer;
		}

		@Override
		public String toString() {
			return "pendingTransfer";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + pendingTransfer;
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
			AccountNumber other = (AccountNumber) obj;
			if (pendingTransfer != other.pendingTransfer)
				return false;
			return true;
		}
		
		}
	
	