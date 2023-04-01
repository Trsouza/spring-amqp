package com.trs.springamqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trs.springamqp.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}