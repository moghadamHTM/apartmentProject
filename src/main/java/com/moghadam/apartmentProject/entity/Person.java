package com.moghadam.apartmentProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String family;
	
	private String personType;
	
	private String mobilePhone;
	
	private String phone;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="building_id")
	private Building building;
	
	@OneToMany(mappedBy="person",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<BuildingUnitPerson> buildingUnitPersons;
	
	public Person() {
		
	}
	
	public Person(String name,String family,String personType,String mobilePhone,String phone) {
		
		this.name=name;
		this.family=family;
		this.personType=personType;
		this.mobilePhone=mobilePhone;
		this.phone=phone;
	}
	
	public Person(Long id,String name,String family,String personType,String mobilePhone,String phone) {
		
		this.id=id;
		this.name=name;
		this.family=family;
		this.personType=personType;
		this.mobilePhone=mobilePhone;
		this.phone=phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<BuildingUnitPerson> getBuildingUnitPersons() {
		return buildingUnitPersons;
	}

	public void setBuildingUnitPersons(List<BuildingUnitPerson> buildingUnitPersons) {
		this.buildingUnitPersons = buildingUnitPersons;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", family=" + family + ", personType=" + personType
				+ ", mobilePhone=" + mobilePhone + ", phone=" + phone + ", building=" + building
				+ ", buildingUnitPersons=" + buildingUnitPersons + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((personType == null) ? 0 : personType.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Person other = (Person) obj;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personType == null) {
			if (other.personType != null)
				return false;
		} else if (!personType.equals(other.personType))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	
	
	

}
