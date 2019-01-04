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
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String province;
	
	private String city;
	
	private String neighbourhood;
	
	private String postalAddress;
	
	private String postalCode;
	
	@OneToOne
	@JoinColumn(name="building_id")
	private Building building;
	
	public Address() {
		
	}
	
	public Address(String province,String city,String neighbourhood,String postalAddress,String postalCode) {
		this.province=province;
		this.city=city;
		this.neighbourhood=neighbourhood;
		this.postalAddress=postalAddress;
		this.postalCode=postalCode;
		
	}
	
	public Address(long id,String province,String city,String neighbourhood,String postalAddress,String postalCode) {
		this.id=id;
		this.province=province;
		this.city=city;
		this.neighbourhood=neighbourhood;
		this.postalAddress=postalAddress;
		this.postalCode=postalCode;
		
	}

	public Address(long id,String province,String city,String neighbourhood,String postalAddress,String postalCode,
			Building building) {
		this.id=id;
		this.province=province;
		this.city=city;
		this.neighbourhood=neighbourhood;
		this.postalAddress=postalAddress;
		this.postalCode=postalCode;
		this.building=building;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + ", neighbourhood=" + neighbourhood
				+ ", postalAddress=" + postalAddress + ", postalCode=" + postalCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((neighbourhood == null) ? 0 : neighbourhood.hashCode());
		result = prime * result + ((postalAddress == null) ? 0 : postalAddress.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (neighbourhood == null) {
			if (other.neighbourhood != null)
				return false;
		} else if (!neighbourhood.equals(other.neighbourhood))
			return false;
		if (postalAddress == null) {
			if (other.postalAddress != null)
				return false;
		} else if (!postalAddress.equals(other.postalAddress))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}
	
	
	
	
	

}
