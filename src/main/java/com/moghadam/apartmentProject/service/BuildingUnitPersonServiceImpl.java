package com.moghadam.apartmentProject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.BuildingUnitPersonRepository;
import com.moghadam.apartmentProject.entity.BuildingUnitPerson;



@Service
@Transactional
public class BuildingUnitPersonServiceImpl implements BuildingUnitPersonService {
	
	@Autowired
	private BuildingUnitPersonRepository buildingUnitPersonRepository;

	@Override
	public BuildingUnitPerson save(BuildingUnitPerson buildingUnitPerson) {
		
		return buildingUnitPersonRepository.save(buildingUnitPerson);
	}

}
