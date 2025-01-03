package com.sourav.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.ecommerce.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
