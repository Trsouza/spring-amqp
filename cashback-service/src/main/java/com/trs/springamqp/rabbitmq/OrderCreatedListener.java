package com.trs.springamqp.rabbitmq;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trs.springamqp.dtos.OrderCreatedEventDTO;
import com.trs.springamqp.models.Cashback;
import com.trs.springamqp.repositories.CashbackRepository;
import com.trs.springamqp.services.CashbackService;

@Component
@RabbitListener(queues = "orders.v1.order-created.generate-cashback")
public class OrderCreatedListener {

//	@RabbitListener(queues = "orders.v1.order-created.generate-cashback")
//    public void onOrderCreated(OrderCreatedEventDTO event) {
//        System.out.println("Id recebido " + event.getId());
//        System.out.println("Value recebido " + event.getValue());
//        System.out.println("Paid recebido " + event.getPaid());
//    }
    
//    private final CashbackRepository cashbackRepository;
//
//    @Autowired
//    public OrderCreatedListener(CashbackRepository orderRepository) {
//        this.cashbackRepository = orderRepository;
//    }
	
	@Autowired
	private CashbackService cashbackService;

    @RabbitHandler
    public void receiveOrderCreatedMessage(OrderCreatedEventDTO order) {
    	if (Boolean.TRUE.equals(order.getPaid())) cashbackService.createCashback(order);
    	else System.out.println("Id recebido da order " + order.getId() + " mas falta ser paga.");
    }

}
