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
import com.moghadam.apartmentProject.entity.Location;
import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.AddressServcie;



@RestController
@RequestMapping("/address")
public class AddressRestController {
	
	@Autowired
	private AddressServcie addressServcie;
	
	@PostMapping("/saveAddress")
	public String saveAddress(@Valid @RequestBody Address address) {
		 addressServcie.save(address);
		return "save Address!!";
	}
	
	
	@GetMapping("/getall")
	public List<Address> getAll() {
		
		return addressServcie.findAll();
	}
	
	@GetMapping("/getAddressById/{id}")
	public Address getAddressById(@PathVariable long id) {
		return addressServcie.findAddressById(id);
	}
	
	
	@PutMapping("/updateAddress/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable long id) {
		return addressServcie.updateAddress(address, id);
	}
	
	/*@GetMapping("/getAddressByProvince/{province}")
	public List<Address> getAddressByProvince(@PathVariable(value="province") String province) {
		
		return addressServcie.fibdByProvinc(province);
	}*/
	
}
