package com.capgemini.beans;

public class Account {
	
	private int acc_number;
	private int amount;
	public int getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(int acc_number) {
		this.acc_number = acc_number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	@Override

	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + acc_number;

		result = prime * result + amount;

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

		if (acc_number != other.acc_number)

			return false;

		if (amount != other.amount)

			return false;

		return true;

	}
}
