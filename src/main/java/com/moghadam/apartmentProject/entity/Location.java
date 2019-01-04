package com.moghadam.apartmentProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String geographicLocation;
	
	private String floor;
	
	@OneToOne
	@JoinColumn(name="buildingUnit_id")
	private BuildingUnit buildingUnit;
	
	public Location() {
		
	}
	
	public Location(String geographicLocation,String floor) {
		this.geographicLocation=geographicLocation;
		this.floor=floor;
	}
	
	public Location(long id,String geographicLocation,String floor) {
		this.id=id;
		this.geographicLocation=geographicLocation;
		this.floor=floor;
	}

	public String getGeographicLocation() {
		return geographicLocation;
	}

	public void setGeographicLocation(String geographicLocation) {
		this.geographicLocation = geographicLocation;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public long getId() {
		return id;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public BuildingUnit getBuildingUnit() {
		return buildingUnit;
	}

	public void setBuildingUnit(BuildingUnit buildingUnit) {
		this.buildingUnit = buildingUnit;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", geographicLocation=" + geographicLocation + ", floor=" + floor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((geographicLocation == null) ? 0 : geographicLocation.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (geographicLocation == null) {
			if (other.geographicLocation != null)
				return false;
		} else if (!geographicLocation.equals(other.geographicLocation))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
