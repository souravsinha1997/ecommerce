package com.sourav.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
