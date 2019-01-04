package com.moghadam.apartmentProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.moghadam.apartmentProject.entity.Building;



public interface BuildingRepository extends CrudRepository<Building, Long> {
	
	@Query("select b from Building b where b.id=:id")
	public Building findBuilding(@Param("id") long id);

}
