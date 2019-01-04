package com.moghadam.apartmentProject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.moghadam.apartmentProject.entity.Location;



public interface LocationRepository extends CrudRepository<Location, Long> {
	
	@Query("select l from Location l where l.id=:id")
	public Location findLocation(@Param("id") long id);

}
