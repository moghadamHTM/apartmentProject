package com.moghadam.apartmentProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moghadam.apartmentProject.entity.BankAccount;




public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	
	@Query("select b from BankAccount b where b.id=:id")
	public BankAccount findBankAccount(@Param("id") long id);

}
