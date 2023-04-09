package com.trs.springamqp.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderCreatedEventDTO {
    private Long id;
    private BigDecimal value;
    private Boolean paid;
	private String date;

    public OrderCreatedEventDTO() {
    }

    public OrderCreatedEventDTO(Long id, BigDecimal value, Boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
    }
    
    public OrderCreatedEventDTO(Long id, BigDecimal value, Boolean paid, String date) {
        this.id = id;
        this.value = value;
        this.paid = paid;
        this.date = date;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    
    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
    
}