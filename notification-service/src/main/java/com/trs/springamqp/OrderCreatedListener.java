package com.trs.springamqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @RabbitListener(queues = "orders.v1.order-created.send-notification")
    public void onOrderCreated(OrderCreatedEventDTO event) {
        System.out.println("Id recebido " + event.getId());
        System.out.println("Valor recebido " + event.getValue());
        System.out.println("Pago recebido " + event.getPaid());
    }

}
