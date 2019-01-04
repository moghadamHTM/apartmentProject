package com.moghadam.apartmentProject.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="buildingUnit")
public class BuildingUnit{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String fundBalance;
	
	private String area;
	
	private String numberPeople;
	
	private String chargeAmount;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="building_id")
	private Building building;
	
	@OneToOne(mappedBy="buildingUnit",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private Location location;
	
	@OneToMany(mappedBy="buildingUnit")
	private List<BuildingUnitPerson> buildingUnitPersons;
	
	public BuildingUnit() {
		
	}
	
	public BuildingUnit(String fundBalance,String area,String numberPeople,String chargeAmount) {
		this.fundBalance=fundBalance;
		this.area=area;
		this.numberPeople=numberPeople;
		this.chargeAmount=chargeAmount;
	}
	
	public BuildingUnit(long id,String fundBalance,String area,String numberPeople,String chargeAmount) {
		this.id=id;
		this.fundBalance=fundBalance;
		this.area=area;
		this.numberPeople=numberPeople;
		this.chargeAmount=chargeAmount;
	}

	public String getFundBalance() {
		return fundBalance;
	}

	public void setFundBalance(String fundBalance) {
		this.fundBalance = fundBalance;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(String numberPeople) {
		this.numberPeople = numberPeople;
	}

	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
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
	
	

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		if (location == null) {
            if (this.location != null) {
                this.location.setBuildingUnit(null);
            }
        }
        else {
        	location.setBuildingUnit(this);
        }
		this.location = location;
	}
	

	public List<BuildingUnitPerson> getBuildingUnitPersons() {
		return buildingUnitPersons;
	}

	public void setBuildingUnitPersons(List<BuildingUnitPerson> buildingUnitPersons) {
		this.buildingUnitPersons = buildingUnitPersons;
	}
	
	public void add(BuildingUnitPerson buildingUnitPerson) {
		if(buildingUnitPersons==null) {
			buildingUnitPersons=new ArrayList<>();
			buildingUnitPersons.add(buildingUnitPerson);
		}
		buildingUnitPerson.setBuildingUnit(this);
	}

	@Override
	public String toString() {
		return "BuildingUnit [id=" + id + ", fundBalance=" + fundBalance + ", area=" + area + ", numberPeople="
				+ numberPeople + ", chargeAmount=" + chargeAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((chargeAmount == null) ? 0 : chargeAmount.hashCode());
		result = prime * result + ((fundBalance == null) ? 0 : fundBalance.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((numberPeople == null) ? 0 : numberPeople.hashCode());
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
		BuildingUnit other = (BuildingUnit) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (fundBalance == null) {
			if (other.fundBalance != null)
				return false;
		} else if (!fundBalance.equals(other.fundBalance))
			return false;
		if (id != other.id)
			return false;
		if (numberPeople == null) {
			if (other.numberPeople != null)
				return false;
		} else if (!numberPeople.equals(other.numberPeople))
			return false;
		return true;
	}
	
	

}
