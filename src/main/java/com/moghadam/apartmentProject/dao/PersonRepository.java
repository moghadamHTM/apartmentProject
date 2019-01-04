package com.moghadam.apartmentProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moghadam.apartmentProject.entity.Person;



public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("select p from Person p where p.family=:family")
	public Person findByFamily(@Param("family") String family);
	
	@Query("select p from Person p where p.id=:id")
	public Person findPersonById(@Param("id") long id);
	
	

}
