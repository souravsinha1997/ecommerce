package com.sourav.payment.entity;

import java.math.BigDecimal;

public class PaymentNotification {

	private String orderReference;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	public PaymentNotification() {
		super();
	}

	public String getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "PaymentNotification [orderReference=" + orderReference + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", customerEmail=" + customerEmail + "]";
	}
	
	
}
