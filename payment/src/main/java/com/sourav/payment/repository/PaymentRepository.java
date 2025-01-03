package com.sourav.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
