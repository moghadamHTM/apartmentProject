package com.moghadam.apartmentProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moghadam.apartmentProject.entity.BuildingUnit;




public interface BuildingUnitRepository extends CrudRepository<BuildingUnit, Long> {
	
	
	@Query("select b from BuildingUnit b where b.id=:id")
	public BuildingUnit findBuildingUnit(@Param("id") long id);

}
