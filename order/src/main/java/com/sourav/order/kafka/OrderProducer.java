package com.sourav.order.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.sourav.order.entity.OrderConfirmation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProducer {

	@Autowired
	private KafkaTemplate<String, OrderConfirmation> kafkaTemplate;
	
	public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
		log.info("Sendig order confirmation");
		Message<OrderConfirmation> message = MessageBuilder
				                             .withPayload(orderConfirmation)
				                             .setHeader(KafkaHeaders.TOPIC, "order-topic")
				                             .build();
		kafkaTemplate.send(message);
		
	}
}
