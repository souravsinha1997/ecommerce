package com.sourav.ecommerce.dto;

import org.springframework.stereotype.Component;

import com.sourav.ecommerce.entity.Address;
import com.sourav.ecommerce.entity.Customer;

@Component
public class DTOMapper {

	public Address addressMapper(CustomerAddressDTO dto) {
		Address address = new Address();
		address.setHouseNumber(dto.getAddress().getHouseNumber());
		address.setStreet(dto.getAddress().getStreet());
		address.setZipCode(dto.getAddress().getZipCode());
		if(dto.getAddress().getId()!=0) address.setId(dto.getAddress().getId());
		return address;
	}
	
	public Customer customerMapper(CustomerAddressDTO dto) {
		Customer customer = new Customer();
		customer.setEmail(dto.getEmail());
		customer.setFirstname(dto.getFirstname());
		customer.setLastname(dto.getLastname());
		if(dto.getCustomerid()!=0) customer.setId(dto.getCustomerid());
		return customer;
	}
	
	public CustomerAddressDTO customerAddressMapper(Customer customer, Address address) {
		CustomerAddressDTO dto = new CustomerAddressDTO();
		dto.setFirstname(customer.getFirstname());
		dto.setLastname(customer.getLastname());
		dto.setEmail(customer.getEmail());
		dto.setCustomerid(customer.getId());
		
		dto.setAddress(address);
		
		return dto;
	}
}
