package com.moghadam.apartmentProject.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moghadam.apartmentProject.entity.Address;





public interface AddressRepository extends CrudRepository<Address, Long> {
	
	@Query("select a from Address a where a.id=:id")
	public Address findAddress(@Param("id") long id);
	
	
}
