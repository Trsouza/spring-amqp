package com.trs.springamqp.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cashback")
public class Cashback {
	
    @Id
    private String id;
    private LocalDateTime cashbackDeliveryDate;
    private Long orderId;
    
	public Cashback() {
	}

	public Cashback(String id, LocalDateTime cashbackDeliveryDate, Long orderId) {
		this.id = id;
		this.cashbackDeliveryDate = cashbackDeliveryDate;
		this.orderId = orderId;
	}
	

    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public LocalDateTime getCashbackDeliveryDate() {
		return cashbackDeliveryDate;
	}


	public void setCashbackDeliveryDate(LocalDateTime cashbackDeliveryDate) {
		this.cashbackDeliveryDate = cashbackDeliveryDate;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


}
