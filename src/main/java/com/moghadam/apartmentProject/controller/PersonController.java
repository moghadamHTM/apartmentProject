package com.moghadam.apartmentProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moghadam.apartmentProject.dao.PersonRepository;
import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="0") int page) {
		model.addAttribute("data",personRepository.findAll(new PageRequest(page, 7)) );
		model.addAttribute("currentPage", page);
		logger.info("Good is logging!!");
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Person person) {
		personService.save(person);
		logger.info("save is new person in database!!");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete")
	public String deletePerson(Long id) {
		personService.delete(id);
		logger.info("delete is person this !!");
		return "redirect:/";
		
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Person findOne(Long id) {
		logger.info("find a person this!!");
		return personRepository.findPersonById(id);
	}

}
