package com.sourav.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.order.entity.OrderLine;

public interface OrderLineRepo extends JpaRepository<OrderLine,Integer>{

	List<OrderLine> findAllByOrderId(int id);

}
