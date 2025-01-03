package com.sourav.order.entity;

import java.math.BigDecimal;
import java.util.List;

import com.sourav.order.customer.entity.Customer;
import com.sourav.order.product.entity.Product;

public class OrderConfirmation {

	private String reference;
	BigDecimal totalAmount;
	PaymentMethod paymentMethod;
	Customer customer;
	List<Product> products;
	
	public OrderConfirmation() {
		super();
	}

	public OrderConfirmation(String reference, BigDecimal totalAmount, PaymentMethod paymentMethod, Customer customer,
			List<Product> products) {
		super();
		this.reference = reference;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		this.products = products;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderConfirmation [reference=" + reference + ", totalAmount=" + totalAmount + ", paymentMethod="
				+ paymentMethod + ", customer=" + customer + ", products=" + products + "]";
	}
	
	
}
