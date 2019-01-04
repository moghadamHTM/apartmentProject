package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.Building;
import com.moghadam.apartmentProject.entity.Location;



public interface BuildingService {
	
	List<Building> findAll();
	
	String save(Building building);
	
	Building findBuildingById(long id);
	
	public Building updateBuilding(Building building, long id);
	
	void delete(long id);

}
