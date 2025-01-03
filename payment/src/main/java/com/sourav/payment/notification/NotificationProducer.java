package com.sourav.payment.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.sourav.payment.entity.Payment;
import com.sourav.payment.entity.PaymentNotification;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationProducer {

	@Autowired
	private KafkaTemplate<String, PaymentNotification> kafkaTemplate;
	
	public void sendNotification(PaymentNotification paymentNotification) {
		log.info("Sendig payment notification");
		Message<PaymentNotification> message = MessageBuilder
				                             .withPayload(paymentNotification)
				                             .setHeader(KafkaHeaders.TOPIC, "payment-topic")
				                             .build();
		kafkaTemplate.send(message);
		
	}
}
