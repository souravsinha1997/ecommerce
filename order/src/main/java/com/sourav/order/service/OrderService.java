package com.sourav.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.order.customer.CustomerClient;
import com.sourav.order.customer.entity.Customer;
import com.sourav.order.entity.Order;
import com.sourav.order.entity.OrderConfirmation;
import com.sourav.order.entity.OrderLine;
import com.sourav.order.entity.OrderRequest;
import com.sourav.order.exception.BusinessException;
import com.sourav.order.kafka.OrderProducer;
import com.sourav.order.payment.PaymentClient;
import com.sourav.order.payment.entity.PaymentRequest;
import com.sourav.order.product.ProductClient;
import com.sourav.order.product.entity.Product;
import com.sourav.order.repository.OrderRepository;

import jakarta.validation.Valid;

@Service
public class OrderService {

	@Autowired
	private CustomerClient customerClient;
	
	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderLineService orderLineService;
	
	@Autowired
	private OrderProducer orderProducer;
	
	@Autowired
	private PaymentClient paymentClient;
	
	public int createOrder(@Valid OrderRequest orderReq) {
		Customer customer = customerClient.findCustomerById(orderReq.getCustomerId()).orElseThrow(()-> new BusinessException("Customer id is invalid ID: "+orderReq.getCustomerId()));
		
		List<Product> purchaseOrder = new ArrayList<>();
		List<OrderLine> orderLines = orderReq.getOrderLine();
		
		for(OrderLine purchase : orderLines) {
			Product product = new Product();
			product.setId(purchase.getProductId());
			product.setAvailableQuantity(purchase.getQuantity());
			purchaseOrder.add(product);
		}
		
		
		List<Product> purchaseProducts = productClient.purchaseProducts(purchaseOrder);
		
		Order order = new Order();
		order.setorderLines(orderLines);
		order.setCustomerId(orderReq.getCustomerId());
		order.setPaymentMethod(orderReq.getPaymentMethod());
		order.setReference(orderReq.getReference());
		order.setTotalAmount(orderReq.getTotalAmount());
		
		Order savedOrder = orderRepository.save(order);
		System.out.println(savedOrder);
		for(Product po : purchaseOrder) {
			OrderLine orderLine = new OrderLine();
			orderLine.setProductId(po.getId());
			orderLine.setQuantity(po.getAvailableQuantity());
			orderLine.setOrderId(savedOrder.getId());
			orderLineService.saveOrderLine(orderLine);
		}
		
		//Payment service for later--------------->
		PaymentRequest payment = new PaymentRequest();
		payment.setAmount(savedOrder.getTotalAmount());
		payment.setCustomer(customer);
		payment.setOrderId(savedOrder.getId());
		payment.setOrderReference(savedOrder.getReference());
		payment.setPaymentMethod(savedOrder.getPaymentMethod());
		
		paymentClient.requestOrderPayment(payment);
		
		OrderConfirmation orderConfirmation = new OrderConfirmation();
		orderConfirmation.setReference(savedOrder.getReference());
		orderConfirmation.setCustomer(customer);
		orderConfirmation.setTotalAmount(savedOrder.getTotalAmount());
		orderConfirmation.setProducts(purchaseProducts);
		orderConfirmation.setPaymentMethod(savedOrder.getPaymentMethod());
		
		orderProducer.sendOrderConfirmation(orderConfirmation);
		
		return order.getId();
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(int id) {
		return orderRepository.findById(id).orElse(null);
	}

}
