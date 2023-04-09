package com.trs.springamqp.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.trs.springamqp.dtos.OrderCreatedEventDTO;
import com.trs.springamqp.models.Cashback;
import com.trs.springamqp.repositories.CashbackRepository;

@Service
public class CashbackService {
	
	@Autowired
	private CashbackRepository repository;
	
    public void createCashback(OrderCreatedEventDTO order) {
    	  
        try {
       	Cashback cashback = new Cashback();
       		var dateOrder = LocalDateTime.parse(order.getDate());
       		cashback.setOrderId(order.getId());
       		cashback.setCashbackDeliveryDate(dateOrder.plusDays(30));
       		
            repository.save(cashback);
            System.out.println("New cashback created: " + cashback);
        } catch ( Exception e) {
            System.err.println("Error processing cashback created message: " + e.getMessage());
        }
    }

//  @Scheduled(cron = "0 0 * * *") executa a meia noite
//  public void cashbackCompleted() {
//      var cashbacks = repository.findAll(); 
//  }
	@Scheduled(fixedRate = 60000) // executa a cada 60 segundos
    public void executeAction() {
        var cashbacks = repository.findAll(); 
  
        if (cashbacks.size()> 10) {
            System.out.println("lista maior");
        } else {
        	 System.out.println("lista menor");
        }
    }
}
