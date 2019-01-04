package com.moghadam.apartmentProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moghadam.apartmentProject.entity.BankAccount;
import com.moghadam.apartmentProject.entity.Location;
import com.moghadam.apartmentProject.service.BankAccountService;



@RestController
@RequestMapping("/bankAccount")
public class BankAccountRestController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/saveBankAccount")
	public String saveBankAccount(@Valid @RequestBody BankAccount bankAccount) {
		bankAccountService.save(bankAccount);
		return "save BankAccount!!";
	}
	
	
	@GetMapping("/getall")
	public List<BankAccount> getAll(){
		return bankAccountService.findAll();
	}
	
	@GetMapping("/getBankAccountById/{id}")
	public BankAccount getBankAccountById(@PathVariable long id) {
		return bankAccountService.findBankAccountById(id);
	}
	
	
	@PutMapping("/updateBankAccount/{id}")
	public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable long id) {
		return bankAccountService.updateBankAccount(bankAccount, id);
	}

}
