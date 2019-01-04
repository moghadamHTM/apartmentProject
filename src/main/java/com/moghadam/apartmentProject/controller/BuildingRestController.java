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

import com.moghadam.apartmentProject.entity.Address;
import com.moghadam.apartmentProject.entity.BankAccount;
import com.moghadam.apartmentProject.entity.Building;
import com.moghadam.apartmentProject.entity.Location;
import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.AddressServcie;
import com.moghadam.apartmentProject.service.BankAccountService;
import com.moghadam.apartmentProject.service.BuildingService;
import com.moghadam.apartmentProject.service.PersonService;



@RestController
@RequestMapping("/building")
public class BuildingRestController {
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private AddressServcie addressService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/saveBuilding/{address_id}/and/{manager_id}/and/{bankAccount_id}")
	public String saveBuilding(@Valid @RequestBody Building building,@PathVariable(value="address_id") long addressId,@PathVariable(value="manager_id") long managerId,@PathVariable(value="bankAccount_id") long bankAccountId) {
		Address address = addressService.findAddressById(bankAccountId);
		Person person = personService.findPersonById(managerId);
		BankAccount bankAccount = bankAccountService.findBankAccountById(bankAccountId);
		building.addPerson(person);
		building.setAddress(address);
		building.setBankAccount(bankAccount);
		buildingService.save(building);
		
		return "save Buildinng!!";
	}
	
	
	@PostMapping("/saveBuilding")
	public void saveBuilding(@Valid @RequestBody Building building) {
		
		buildingService.save(building);
		
		//return "save Buildinng!!";
	}
	
	@GetMapping("/getBuildings")
	public List<Building> getBuildings(){
		return buildingService.findAll();
	}
	
	@GetMapping("/getBuildingById/{id}")
	public Building getBuildingById(@PathVariable long id) {
		return buildingService.findBuildingById(id);
	}
	
	
	@PutMapping("/updateBuilding/{id}")
	public Building updateBuilding(@RequestBody Building building, @PathVariable long id) {
		return buildingService.updateBuilding(building, id);
	}

}
