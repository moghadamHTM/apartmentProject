package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.BuildingUnit;
import com.moghadam.apartmentProject.entity.Location;




public interface BuildingUnitService {
	
	List<BuildingUnit> findAll();
	
	String save(BuildingUnit buildingUnit);
	
	BuildingUnit findBuildingUnitById(long id);
	
	public BuildingUnit updateBuildingUnit(BuildingUnit buildingUnit,long id);
	
	void delete(long id);


}
