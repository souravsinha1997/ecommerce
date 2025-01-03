package com.sourav.order.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OrderRequest {

	private int id;
	private int customerId;
	private List<OrderLine> orderLine;
	private String reference;
	private BigDecimal totalAmount;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	public OrderRequest() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
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

	@Override
	public String toString() {
		return "OrderRequest [id=" + id + ", customerId=" + customerId + ", orderLine=" + orderLine + ", reference="
				+ reference + ", totalAmount=" + totalAmount + ", paymentMethod=" + paymentMethod + "]";
	}
	
	
}
