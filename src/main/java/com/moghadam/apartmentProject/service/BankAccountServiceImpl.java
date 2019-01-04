package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.BankAccountRepository;
import com.moghadam.apartmentProject.entity.BankAccount;




@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public List<BankAccount> findAll() {
		List<BankAccount> bankAccounts=new ArrayList<>();
		for (BankAccount bankAccount : bankAccountRepository.findAll()) {
			 bankAccounts.add(bankAccount);
		}
		return  bankAccounts;
	}

	@Override
	public String save(BankAccount bankAccount) {
		bankAccountRepository.save(bankAccount);
		return bankAccount.getBankName();
		
	}

	@Override
	public BankAccount findBankAccountById(long id) {
		
		return bankAccountRepository.findBankAccount(id);
	}

	@Override
	public void delete(long id) {
		bankAccountRepository.deleteById(id);
		
	}

	@Override
	public BankAccount updateBankAccount(BankAccount bankAccount, long id) {
		return bankAccountRepository.findById(id).map(newBankAccount -> {
			newBankAccount.setBankName(bankAccount.getBankName());
			newBankAccount.setAccountNumber(bankAccount.getAccountNumber());
			newBankAccount.setCardNumber(bankAccount.getAccountNumber());
			return bankAccountRepository.save(newBankAccount);
		}).orElseGet(() -> {
			bankAccount.setId(id);
			return bankAccountRepository.save(bankAccount);
		});
	}

}
