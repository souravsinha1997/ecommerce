package com.sourav.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="customer_order")
public class Order {

	@Id
	@GeneratedValue
	private int id;
	private String reference;
	@Positive(message = "Order amount should be positive")
	private BigDecimal totalAmount;
	@Enumerated(EnumType.STRING)
	@NotNull(message="Payment method is required")
	private PaymentMethod paymentMethod;
	private int customerId;
	@OneToMany(mappedBy = "orderId")
	private List<OrderLine> orderLines;
	@CreatedDate
	@Column(updatable=false, nullable = false)
	private LocalDateTime createdAt;
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDateTime lastModifiedDate;
	
	public Order() {
		super();
	}

	public Order(int id, String reference, BigDecimal totalAmount, PaymentMethod paymentMethod, int customerId,
			List<OrderLine> orderLines, LocalDateTime createdAt, LocalDateTime lastModifiedDate) {
		super();
		this.id = id;
		this.reference = reference;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.customerId = customerId;
		this.orderLines = orderLines;
		this.createdAt = createdAt;
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getorderLines() {
		return orderLines;
	}

	public void setorderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", reference=" + reference + ", totalAmount=" + totalAmount + ", paymentMethod="
				+ paymentMethod + ", customerId=" + customerId + ", orderLines=" + orderLines + ", createdAt=" + createdAt
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}	
	
}
