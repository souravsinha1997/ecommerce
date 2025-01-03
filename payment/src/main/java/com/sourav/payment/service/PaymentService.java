package com.sourav.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.payment.entity.Payment;
import com.sourav.payment.entity.PaymentNotification;
import com.sourav.payment.entity.PaymentRequest;
import com.sourav.payment.notification.NotificationProducer;
import com.sourav.payment.repository.PaymentRepository;

import jakarta.validation.Valid;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private NotificationProducer notificationProducer;
	
	public int createPayment(@Valid PaymentRequest paymentReq) {
		Payment payment = new Payment();
		payment.setAmount(paymentReq.getAmount());
		payment.setOrderId(paymentReq.getOrderId());
		payment.setPaymentMethod(paymentReq.getPaymentMethod());
		
		Payment completed = paymentRepository.save(payment);
		PaymentNotification notification = new PaymentNotification();
		notification.setAmount(paymentReq.getAmount());
		notification.setCustomerEmail(paymentReq.getCustomer().getEmail());
		notification.setCustomerFirstName(paymentReq.getCustomer().getFirstname());
		notification.setCustomerLastName(paymentReq.getCustomer().getLastname());
		notification.setOrderReference(paymentReq.getOrderReference());
		notification.setPaymentMethod(paymentReq.getPaymentMethod());
		
		
		notificationProducer.sendNotification(notification);
		return completed.getId();
	}
	
}
