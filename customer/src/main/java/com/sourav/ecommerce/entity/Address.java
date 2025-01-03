package com.sourav.ecommerce.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Validated
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String houseNumber;
	private String zipCode;
	
		
	public Address() {
		super();
	}
	
	
	public Address(int id, String street, String houseNumber, String zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", houseNumber=" + houseNumber + ", zipCode=" + zipCode
				+ "]";
	}
	
	
	
	
}
