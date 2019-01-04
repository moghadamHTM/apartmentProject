package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.BuildingRepository;
import com.moghadam.apartmentProject.entity.Building;




@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<Building> findAll() {
		List<Building> buildings=new ArrayList<>();
		for (Building building : buildingRepository.findAll()) {
			buildings.add(building);
		}
		return buildings;
	}

	@Override
	public String save(Building building) {
		buildingRepository.save(building);
		return building.getName();
		
	}

	@Override
	public Building findBuildingById(long id) {
		
		return buildingRepository.findBuilding(id);
	}

	@Override
	public void delete(long id) {
		buildingRepository.deleteById(id);
		
	}

	@Override
	public Building updateBuilding(Building building, long id) {
		return buildingRepository.findById(id).map(newBuilding -> {
			newBuilding.setName(building.getName());
			newBuilding.setFundBalance(building.getFundBalance());
			newBuilding.setNumberBuildingUnite(building.getNumberBuildingUnite());
			return buildingRepository.save(newBuilding);
		}).orElseGet(() -> {
			building.setId(id);
			return buildingRepository.save(building);
		});
	}

}
