package com.trs.springamqp.services;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.springamqp.dtos.OrderCreatedEventDTO;
import com.trs.springamqp.dtos.OrderDTO;
import com.trs.springamqp.models.Order;
import com.trs.springamqp.repositories.OrderRepository;


@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Transactional(readOnly = true)
	public Collection<Order> list() {
		return orderRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Order findById(Long id) {
		return orderRepo.findById(id).orElseThrow();
	}

	@Transactional
	public Order pay(Long id) {
		Order order = orderRepo.findById(id).orElseThrow();
		order.markAsPaid();
		
		orderRepo.save(order);
		
		OrderCreatedEventDTO event = new OrderCreatedEventDTO(order.getId(), order.getValue(), order.isPaid());
		rabbitTemplate.convertAndSend("orders.v1.order-created", "", event);
		
		return order;
	}

	@Transactional
	public Order create(OrderDTO orderDTO) {
		var order = modelMapper.map(orderDTO, Order.class);
		orderRepo.save(order);

		OrderCreatedEventDTO event = new OrderCreatedEventDTO(order.getId(), order.getValue(), order.isPaid());
		rabbitTemplate.convertAndSend("orders.v1.order-created", "", event);

		return modelMapper.map(order, Order.class);
	}

}
