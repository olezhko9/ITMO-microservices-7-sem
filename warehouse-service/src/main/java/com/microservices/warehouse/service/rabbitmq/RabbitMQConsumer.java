package com.microservices.warehouse.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "order-warehouse")
    public void orderQueueConsumer(Object message) {
        System.out.println("Received message: " + message);
    }
}
