package com.moghadam.apartmentProject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class Building {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String fundBalance;
	
	private String numberBuildingUnite;
	
	@OneToMany(mappedBy="building",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<BuildingUnit> buildingUnits;
	
	@OneToOne(mappedBy="building",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private Address address;
	
	@OneToMany(mappedBy="building",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Person> persons; 
	
	@OneToOne(mappedBy="building",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private BankAccount bankAccount; 
	
	public Building() {
		
	}
	
	public Building(String name,String fundBalance,String numberBuildingUnite) {
		this.name=name;
		this.fundBalance=fundBalance;
		this.numberBuildingUnite=numberBuildingUnite;
	}
	
	public Building(long id,String name,String fundBalance,String numberBuildingUnite) {
		this.id=id;
		this.name=name;
		this.fundBalance=fundBalance;
		this.numberBuildingUnite=numberBuildingUnite;
	}

	public String getFundBalance() {
		return fundBalance;
	}

	public void setFundBalance(String fundBalance) {
		this.fundBalance = fundBalance;
	}

	public String getNumberBuildingUnite() {
		return numberBuildingUnite;
	}

	public void setNumberBuildingUnite(String numberBuildingUnite) {
		this.numberBuildingUnite = numberBuildingUnite;
	}

	public long getId() {
		return id;
	}
	

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BuildingUnit> getBuildingUnits() {
		return buildingUnits;
	}

	public void setBuildingUnits(List<BuildingUnit> buildingUnits) {
		this.buildingUnits = buildingUnits;
	}
	
	public void addBuildingUnit(BuildingUnit buildingUnit) {
		if(buildingUnits==null) {
			buildingUnits=new ArrayList<>();
		}
		
		buildingUnits.add(buildingUnit);
		buildingUnit.setBuilding(this);
	}
	
	public void addPerson(Person person) {
		if(persons==null) {
			persons=new ArrayList<>();
		}
		persons.add(person);
		person.setBuilding(this);
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if (address == null) {
            if (this.address != null) {
                this.address.setBuilding(null);
            }
        }
        else {
        	address.setBuilding(this);
        }
		this.address = address;
	}


	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		if (bankAccount == null) {
            if (this.bankAccount != null) {
                this.bankAccount.setBuilding(null);
            }
        }
        else {
        	bankAccount.setBuilding(this);
        }
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", fundBalance=" + fundBalance + ", numberBuildingUnite="
				+ numberBuildingUnite + ", buildingUnits=" + buildingUnits + ", address=" + address + ", bankAccount="
				+ bankAccount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fundBalance == null) ? 0 : fundBalance.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberBuildingUnite == null) ? 0 : numberBuildingUnite.hashCode());
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
		Building other = (Building) obj;
		if (fundBalance == null) {
			if (other.fundBalance != null)
				return false;
		} else if (!fundBalance.equals(other.fundBalance))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberBuildingUnite == null) {
			if (other.numberBuildingUnite != null)
				return false;
		} else if (!numberBuildingUnite.equals(other.numberBuildingUnite))
			return false;
		return true;
	}

	

	

	

	
	

	
	
	
	
	

}
