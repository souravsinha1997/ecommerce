package com.sourav.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.ecommerce.entity.Address;
import com.sourav.ecommerce.entity.Customer;
import com.sourav.ecommerce.exceprion.CustomerNotFoundExceptoion;
import com.sourav.ecommerce.repository.AddressRepository;

import jakarta.validation.Valid;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public int createAddress(Address address) {
		addressRepository.save(address);
		return address.getId();
	}
	
	public void updateAddress(@Valid Address address) {
		Address savedAddress = addressRepository.findById(address.getId()).orElse(null);
		if(savedAddress == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+address.getId()+" is not available");
		}
		
		if(address.getHouseNumber() != null || address.getHouseNumber() != "") savedAddress.setHouseNumber(address.getHouseNumber());
		if(address.getStreet() != null || address.getStreet() != "") savedAddress.setStreet(address.getStreet());
		if(address.getZipCode() != null || address.getZipCode() != "") savedAddress.setZipCode(address.getZipCode());
		
		addressRepository.save(savedAddress);
	}
	
	public Address getAddress(int id) {
		Address savedAddress = addressRepository.findById(id).orElse(null);
		if(savedAddress == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+id+" is not available");
		}
		return savedAddress;
	}
	
	public void deleteAddress(int id) {
		Address savedAddress = addressRepository.findById(id).orElse(null);
		if(savedAddress == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+id+" is not available");
		}
		addressRepository.delete(savedAddress);
	}
	
	public List<Address> getAllAddress() {
		List<Address> addresses = addressRepository.findAll();
		return addresses;
	}
	
}
