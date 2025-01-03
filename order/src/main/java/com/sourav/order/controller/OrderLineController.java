package com.sourav.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.order.entity.OrderLine;
import com.sourav.order.service.OrderLineService;

@RestController
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

	@Autowired
	private OrderLineService orderLineService;
	
	@GetMapping("/order/{id}")
	public ResponseEntity<List<OrderLine>> getOrderById(@PathVariable int id){
		return ResponseEntity.ok(orderLineService.findAllByOrderId(id));
	}
}
