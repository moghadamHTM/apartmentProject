package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.Location;




public interface LocationService {
	
	List<Location> findAll();
	
	String save(Location location);
	
	Location findLocationById(long id);
	
	void delete(long id);
	
	public Location updateLocation(Location location,long id);

}
