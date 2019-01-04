package com.moghadam.apartmentProject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BuildingUnitPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="buildingUnit_id")
	private BuildingUnit buildingUnit;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="person_id")
	private Person person;
	
	public BuildingUnitPerson() {
		
	}

	public BuildingUnit getBuildingUnit() {
		return buildingUnit;
	}

	public void setBuildingUnit(BuildingUnit buildingUnit) {
		this.buildingUnit = buildingUnit;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BuildingUnitPerson [id=" + id + ", buildingUnit=" + buildingUnit + ", person=" + person + "]";
	}
	
	
	
	
	

}
