package com.sourav.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.payment.entity.Payment;
import com.sourav.payment.entity.PaymentRequest;
import com.sourav.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest paymentReq){

		return ResponseEntity.ok(paymentService.createPayment(paymentReq));
	}
}
