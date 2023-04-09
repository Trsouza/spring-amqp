package com.trs.springamqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.trs.springamqp.dtos.OrderDTO;
import com.trs.springamqp.models.Order;
import com.trs.springamqp.services.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public Order create(@RequestBody OrderDTO order) {
		return service.create(order);
	}

	@GetMapping
	public List<Order> list() {
		return service.list();
	}

	@GetMapping("{id}")
	public Order findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping("{id}/pay")
	public Order pay(@PathVariable Long id) {
		return service.pay(id);
	}
	
}
