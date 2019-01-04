package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.PersonRepository;
import com.moghadam.apartmentProject.entity.Person;




@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		List<Person> persons=new ArrayList<>();
		for (Person person : personRepository.findAll()) {
			persons.add(person);
		}
		return persons;
	}

	

	@Override
	public Person findPersonById(long id) {
		Person person = personRepository.findPersonById(id);
		if(person!=null) {
			return person;
		}
		
		return null;
	}

	@Override
	public void delete(long id) {
		personRepository.deleteById(id);
		
	}

	@Override
	public Person findByFamily(String family) {
		
		Person person = personRepository.findByFamily(family);
		
		if(person!=null) {
			return person;
		}
		
		return null;
	}



	@Override
	public String save(Person person) {
		
		 personRepository.save(person);
		  return person.getFamily();
		 }
	@Override
	public Person updatePerson(Person person,long id) {
		return personRepository.findById(id).map(newPerson -> {
					newPerson.setName(person.getName());
					newPerson.setFamily(person.getFamily());
					newPerson.setPersonType(person.getPersonType());
					newPerson.setMobilePhone(person.getMobilePhone());
					newPerson.setPhone(person.getPhone());
					return personRepository.save(newPerson);
				}).orElseGet(() -> {
					person.setId(id);
					return personRepository.save(person);
				});
	}

}
