package com.sourav.ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
