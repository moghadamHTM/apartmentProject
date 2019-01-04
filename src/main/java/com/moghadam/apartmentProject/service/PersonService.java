package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.Person;





public interface PersonService {
	
	List<Person> findAll();
	
	String save( Person person);
	
	Person findPersonById(long id);
	
	void delete(long id);
	
	public Person findByFamily(String family);
	
	public Person updatePerson(Person person,long id);

}
