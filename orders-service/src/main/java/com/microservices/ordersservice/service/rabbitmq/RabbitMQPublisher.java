package com.microservices.ordersservice.service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${order.rabbitmq.exchange}")
    private String exchange;

    public void publish(String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Send msg = " + message);
    }
}
