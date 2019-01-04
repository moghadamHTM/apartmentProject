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

import com.moghadam.apartmentProject.entity.Building;
import com.moghadam.apartmentProject.entity.BuildingUnit;
import com.moghadam.apartmentProject.entity.BuildingUnitPerson;
import com.moghadam.apartmentProject.entity.Location;
import com.moghadam.apartmentProject.entity.Person;
import com.moghadam.apartmentProject.service.BuildingService;
import com.moghadam.apartmentProject.service.BuildingUnitPersonService;
import com.moghadam.apartmentProject.service.BuildingUnitService;
import com.moghadam.apartmentProject.service.LocationService;
import com.moghadam.apartmentProject.service.PersonService;



@RestController
@RequestMapping("/buildingUnit")
public class BuildingUnitRestController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private BuildingUnitService buildingUnitService;
	
	@Autowired
	private BuildingUnitPersonService buildingUnitPersonService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private BuildingService buildingService;
	
	
	@PostMapping("/saveBuildingUnit")
	public String saveBuildingUnit(@Valid @RequestBody BuildingUnit buildingUnit ) {
		buildingUnitService.save(buildingUnit);
		return "buildingUnit save!!";
	}
	
	
	@PostMapping("/saveBuildingUnit/{buildingOwner_id}/and/{location_id}")
	public String saveBuildingUnit(@Valid @RequestBody BuildingUnit buildingUnit,@PathVariable(value="buildingOwner_id") long ownerId ,@PathVariable(value="location_id") long locationId) {
		Person person = personService.findPersonById(ownerId);
		Location location = locationService.findLocationById(locationId);
		BuildingUnitPerson buildingUnitPerson=new BuildingUnitPerson();
		buildingUnitPerson.setPerson(person);
		buildingUnitPersonService.save(buildingUnitPerson);
		buildingUnit.add(buildingUnitPerson);
		buildingUnit.setLocation(location);
		buildingUnitService.save(buildingUnit);
		return "buildingUnit save!!";
	}
	
	@PostMapping("/saveBuildingUnit/{buildingOwner_id}/and/{buildingTenant_id}/and/{location_id}/and/{building_id}")
	public String saveBuildingUnit(@Valid @RequestBody BuildingUnit buildingUnit,@PathVariable(value="buildingOwner_id") long ownerId ,@PathVariable(value="buildingTenant_id") long tenantId,@PathVariable(value="location_id") long locationId,@PathVariable(value="building_id") long buildingId) {
		Person person1 = personService.findPersonById(ownerId);
		Person person2 = personService.findPersonById(tenantId);
		Location location = locationService.findLocationById(locationId);
		Building building = buildingService.findBuildingById(buildingId);
		BuildingUnitPerson buildingUnitPerson1=new BuildingUnitPerson();
		buildingUnitPerson1.setPerson(person1);
		buildingUnitPersonService.save(buildingUnitPerson1);
		BuildingUnitPerson buildingUnitPerson2=new BuildingUnitPerson();
		buildingUnitPerson2.setPerson(person2);
		buildingUnitPersonService.save(buildingUnitPerson2);
		buildingUnit.add(buildingUnitPerson1);
		buildingUnit.add(buildingUnitPerson2);
		buildingUnit.setLocation(location);
		buildingUnit.setBuilding(building);
		buildingUnitService.save(buildingUnit);
		return "buildingUnit save!!";
	}
	
	
	@GetMapping("/getall")
	public List<BuildingUnit> getAll(){
		return buildingUnitService.findAll();
	}
	
	@GetMapping("/getBuildingUnitById/{id}")
	public BuildingUnit getBuildingUnitById(@PathVariable long id) {
		return buildingUnitService.findBuildingUnitById(id);
	}
	
	
	@PutMapping("/updateBuildingUnit/{id}")
	public BuildingUnit updateBuildingUnit(@RequestBody BuildingUnit buildingUnit, @PathVariable long id) {
		return buildingUnitService.updateBuildingUnit(buildingUnit, id);
	}
	
	

}
