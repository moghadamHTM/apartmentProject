package com.moghadam.apartmentProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moghadam.apartmentProject.dao.AddressRepository;
import com.moghadam.apartmentProject.entity.Address;




@Service
@Transactional
public class AddressServcieImpl implements AddressServcie {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		List<Address> addresses=new ArrayList<>();
		for (Address address : addressRepository.findAll()) {
			addresses.add(address);
		}
		return addresses;
	}

	@Override
	public String save(Address address) {
		addressRepository.save(address);
		return address.getCity();
	}

	@Override
	public Address findAddressById(long id) {
		
		return addressRepository.findAddress(id);
	}

	@Override
	public void delete(long id) {
		addressRepository.deleteById(id);
		
	}

	@Override
	public Address updateAddress(Address address, long id) {
		return addressRepository.findById(id).map(newAddress -> {
			newAddress.setProvince(address.getProvince());
			newAddress.setCity(address.getCity());
			newAddress.setNeighbourhood(address.getNeighbourhood());
			newAddress.setPostalAddress(address.getPostalAddress());
			newAddress.setPostalCode(address.getPostalCode());
			return addressRepository.save(newAddress);
		}).orElseGet(() -> {
			address.setId(id);
			return addressRepository.save(address);
		});
	}

	

}
