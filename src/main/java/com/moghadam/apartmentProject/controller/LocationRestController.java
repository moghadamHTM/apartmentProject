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

import com.moghadam.apartmentProject.entity.Location;
import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.LocationService;



@RestController
@RequestMapping("/location")
public class LocationRestController {
	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/saveLocation")
	public String saveLocation(@Valid @RequestBody Location location) {
		
		locationService.save(location);
		return "save Location!!";
		
	}
	
	@GetMapping("/getall")
	public List<Location> getAll(){
		return locationService.findAll();
	}
	
	@GetMapping("/getLocationById/{id}")
	public Location getLocationById(@PathVariable long id) {
		return locationService.findLocationById(id);
	}
	
	
	@PutMapping("/updateLocation/{id}")
	public Location updateLocation(@RequestBody Location location, @PathVariable long id) {
		return locationService.updateLocation(location, id);
	}

}
