package com.sourav.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.order.entity.OrderLine;
import com.sourav.order.repository.OrderLineRepo;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepo orderLineRepo;
	
	public void saveOrderLine(OrderLine orderLine) {
		
		orderLineRepo.save(orderLine);
	}

	public List<OrderLine> findAllByOrderId(int id) {
		return orderLineRepo.findAllByOrderId(id);
	}

}
