package com.moghadam.apartmentProject.service;

import java.util.List;

import com.moghadam.apartmentProject.entity.Address;
import com.moghadam.apartmentProject.entity.Location;



public interface AddressServcie {
	
	List<Address> findAll();
	
	String save(Address address);
	
	Address findAddressById(long id);
	
	public Address updateAddress(Address address,long id);
	
	void delete(long id);
	
	

}
