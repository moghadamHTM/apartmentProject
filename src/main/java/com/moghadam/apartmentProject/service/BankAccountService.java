package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.BankAccount;
import com.moghadam.apartmentProject.entity.Location;


public interface BankAccountService {
	
	List<BankAccount> findAll();
	
	String save(BankAccount bankAccount);
	
	BankAccount findBankAccountById(long id);
	
	public BankAccount updateBankAccount(BankAccount bankAccount,long id);
	
	void delete(long id);

}
