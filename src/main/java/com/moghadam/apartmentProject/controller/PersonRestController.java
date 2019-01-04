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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.PersonService;




@RestController
@RequestMapping("/person")
public class PersonRestController {
	
	@Autowired
	private PersonService personService;
	
	
	
	
	@PostMapping("/savePerson")
	public String savePerson(@Valid @RequestBody Person person) {
		personService.save(person);
		return "Person save!!";
	}
	
	@GetMapping("/getall")
	public List<Person> getAllPerson(){
		return personService.findAll();
	}
	
	@GetMapping("/getPersonById/{id}")
	public Person getPersonById(@PathVariable long id) {
		return personService.findPersonById(id);
	}
	
	@GetMapping("/getPersonByFamily/{family}")
	public Person findByFamily(@PathVariable String family){
		return personService.findByFamily(family);
	}
	
	@PutMapping("/updatePerson/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable long id) {
		return personService.updatePerson(person, id);
	}

}
