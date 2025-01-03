package com.sourav.order.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sourav.order.payment.entity.PaymentRequest;

@FeignClient(
		name = "payment-service",
		url = "${application.config.payment-url}"
		)
@Component
public interface PaymentClient {
	
	@PostMapping
	Integer requestOrderPayment(@RequestBody PaymentRequest request);

}
