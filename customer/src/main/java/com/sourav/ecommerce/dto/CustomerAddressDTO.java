package com.sourav.ecommerce.dto;

import com.sourav.ecommerce.entity.Address;

public class CustomerAddressDTO {

	private int customerid;
	private String firstname;
	private String lastname;
	private String email;
	private Address address;
		
	public CustomerAddressDTO(int customerid, String firstname, String lastname, String email,Address address) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}	
	public CustomerAddressDTO() {
		super();
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerAddressDTO [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + " Address="+address+ "]";
	}
	
	
}
