package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.LocationRepository;
import com.moghadam.apartmentProject.entity.Location;




@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		List<Location> locations=new ArrayList<>();
		for (Location location : locationRepository.findAll()) {
			locations.add(location);
		}
		return locations;
	}

	@Override
	public String save(Location location) {
		locationRepository.save(location);
		return location.getGeographicLocation();
		
	}

	@Override
	public Location findLocationById(long id) {
		
		return locationRepository.findLocation(id);
		}

	@Override
	public void delete(long id) {
		locationRepository.deleteById(id);
		
	}

	@Override
	public Location updateLocation(Location location, long id) {
		return locationRepository.findById(id).map(newLocation -> {
			newLocation.setGeographicLocation(location.getGeographicLocation());
			newLocation.setFloor(location.getFloor());
			return locationRepository.save(newLocation);
		}).orElseGet(() -> {
			location.setId(id);
			return locationRepository.save(location);
		});
	}
	
	

}
