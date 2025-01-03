package com.sourav.order.customer;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sourav.order.customer.entity.Customer;

@FeignClient(
		name = "customer-service",
		url = "${application.config.customer-url}"
		)
@Component
public interface CustomerClient {

	@GetMapping("/{id}")
	Optional<Customer> findCustomerById(@PathVariable int id);
}
