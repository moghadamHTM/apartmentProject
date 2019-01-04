package com.moghadam.apartmentProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String bankName;
	
	private String accountNumber;
	
	private String cardNumber;
	
	@OneToOne
	@JoinColumn(name="building_id")
	private Building building;
	
	public BankAccount() {
		
	}
	
	public BankAccount(String bankName,String accountNumber,String cardNumber) {
		this.bankName=bankName;
		this.accountNumber=accountNumber;
		this.cardNumber=cardNumber;
	}
	
	public BankAccount(long id,String bankName,String accountNumber,String cardNumber) {
		this.id=id;
		this.bankName=bankName;
		this.accountNumber=accountNumber;
		this.cardNumber=cardNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getId() {
		return id;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", cardNumber="
				+ cardNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		BankAccount other = (BankAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
