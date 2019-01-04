package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.BuildingUnitRepository;
import com.moghadam.apartmentProject.entity.BuildingUnit;




@Service
@Transactional
public class BuildingUnitServiceImpl implements BuildingUnitService {
	
	@Autowired
	private BuildingUnitRepository buildingUnitRepository;

	@Override
	public List<BuildingUnit> findAll() {
		List<BuildingUnit> buildingUnits=new ArrayList<>();
		
		for (BuildingUnit buildingUnit : buildingUnitRepository.findAll()) {
			buildingUnits.add(buildingUnit);
		}
		return buildingUnits;
	}

	@Override
	public String save(BuildingUnit buildingUnit) {
		buildingUnitRepository.save(buildingUnit);
		return buildingUnit.getArea();
		
	}

	@Override
	public BuildingUnit findBuildingUnitById(long id) {
		
		return buildingUnitRepository.findBuildingUnit(id);
	}

	@Override
	public void delete(long id) {
		buildingUnitRepository.deleteById(id);
		
	}

	@Override
	public BuildingUnit updateBuildingUnit(BuildingUnit buildingUnit, long id) {
		
		return buildingUnitRepository.findById(id).map(newBuildingUnit -> {
			newBuildingUnit.setFundBalance(buildingUnit.getFundBalance());
			newBuildingUnit.setArea(buildingUnit.getArea());
			newBuildingUnit.setNumberPeople(buildingUnit.getNumberPeople());
			newBuildingUnit.setChargeAmount(buildingUnit.getChargeAmount());
			return buildingUnitRepository.save(newBuildingUnit);
		}).orElseGet(() -> {
			buildingUnit.setId(id);
			return buildingUnitRepository.save(buildingUnit);
		});
	}

}
