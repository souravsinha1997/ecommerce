package com.sourav.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.ecommerce.entity.Customer;
import com.sourav.ecommerce.exceprion.CustomerNotFoundExceptoion;
import com.sourav.ecommerce.repository.CustomerRepository;

import jakarta.validation.Valid;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public int createCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer.getId();
	}

	public void updateCustomer(@Valid Customer customer) {
		Customer savedCustomer = customerRepository.findById(customer.getId()).orElse(null);
		if(savedCustomer == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+customer.getId()+" is not available");
		}
		
		if(customer.getFirstname() != null || customer.getFirstname() != "") savedCustomer.setFirstname(customer.getFirstname());
		if(customer.getLastname() != null || customer.getLastname() != "") savedCustomer.setLastname(customer.getLastname());
		if(customer.getEmail() != null || customer.getEmail() != "") savedCustomer.setEmail(customer.getEmail());
		
		customerRepository.save(savedCustomer);
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	public Customer getCustomer(int id) {
		Customer savedCustomer = customerRepository.findById(id).orElse(null);
		if(savedCustomer == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+id+" is not available");
		}
		return savedCustomer;
	}

	public Customer checkCustomer(int id) {
		Customer savedCustomer = customerRepository.findById(id).orElse(null);
		return savedCustomer;
	}

	public void deleteCustomer(int id) {
		Customer savedCustomer = customerRepository.findById(id).orElse(null);
		if(savedCustomer == null) {
			throw new CustomerNotFoundExceptoion("Customer ID: "+id+" is not available");
		}
		customerRepository.delete(savedCustomer);
	}

}
