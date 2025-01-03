package com.sourav.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.ecommerce.dto.CustomerAddressDTO;
import com.sourav.ecommerce.dto.DTOMapper;
import com.sourav.ecommerce.entity.Address;
import com.sourav.ecommerce.entity.Customer;
import com.sourav.ecommerce.service.AddressService;
import com.sourav.ecommerce.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private DTOMapper mapper;
	
	@PostMapping
	public ResponseEntity<Integer> createCustomer(@RequestBody @Valid CustomerAddressDTO customerDto){
		
		Address address = mapper.addressMapper(customerDto);
		int addressId = addressService.createAddress(address);
		
		Customer customer = mapper.customerMapper(customerDto);
		customer.setAddressId(addressId);
		
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerAddressDTO customerDto){
		
		Address address = mapper.addressMapper(customerDto);
		
		Customer customer = mapper.customerMapper(customerDto);
		
		addressService.updateAddress(address);
		customerService.updateCustomer(customer);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerAddressDTO>> getAllCustomers(){
		List<Address> addresses = addressService.getAllAddress();
		List<Customer> customers = customerService.getAllCustomer();
		
		List<CustomerAddressDTO> customerAndAddress =  new ArrayList<>();
		
		for(Customer customer : customers) {
			int addressId = customer.getAddressId();
			Optional<Address> val = addresses.stream().filter(addr -> addr.getId()==addressId).findFirst();
			Address address = val.get();
			customerAndAddress.add(mapper.customerAddressMapper(customer, address));
		}
		
		
		return ResponseEntity.ok(customerAndAddress);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerAddressDTO> getCustomer(@PathVariable int id){
		Customer customer = customerService.getCustomer(id);
		int addressId = customer.getAddressId();
		Address address = addressService.getAddress(addressId);
		CustomerAddressDTO response = mapper.customerAddressMapper(customer, address);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(id);
		int addressId = customer.getAddressId();
		addressService.deleteAddress(addressId);
		
		return ResponseEntity.ok("Customer Deleted Successfully ID: "+id);
	}
	
	@GetMapping("/exist/{id}")
	public ResponseEntity<Boolean> checkCustomer(@PathVariable int id){
		Customer customer = customerService.checkCustomer(id);
		return ResponseEntity.ok(customer != null);
	}
}
