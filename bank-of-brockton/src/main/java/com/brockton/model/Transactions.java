package com.brockton.model;

public class Transactions {

		private int id;
		private String transactionType;
		private int amount;
		private int accountNumber;
		
		public Transactions() {
			super();

	}
		
		public Transactions(int id, String transactionType, int amount, int accountNumber) {
			
			this.id = id;
			this.transactionType = transactionType;
			this.amount = amount;
			this.accountNumber = accountNumber;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}

		@Override
		public String toString() {
			return "Transactions [id=" + id + ", transactionType=" + transactionType + ", amount=" + amount
					+ ", accountNumber=" + accountNumber + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + accountNumber;
			result = prime * result + amount;
			result = prime * result + id;
			result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
			Transactions other = (Transactions) obj;
			if (accountNumber != other.accountNumber)
				return false;
			if (amount != other.amount)
				return false;
			if (id != other.id)
				return false;
			if (transactionType == null) {
				if (other.transactionType != null)
					return false;
			} else if (!transactionType.equals(other.transactionType))
				return false;
			return true;
		}

		
}
