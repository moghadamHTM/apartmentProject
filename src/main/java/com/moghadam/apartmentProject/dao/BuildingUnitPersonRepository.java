package com.moghadam.apartmentProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.moghadam.apartmentProject.entity.BuildingUnitPerson;



public interface BuildingUnitPersonRepository extends CrudRepository<BuildingUnitPerson, Long> {
	
	@Query("select b from BuildingUnitPerson b where b.id=:id")
	public BuildingUnitPerson findBuildingUnitPerson(@Param("id") long id);


}
