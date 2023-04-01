package com.trs.springamqp.dtos;

import java.math.BigDecimal;

public class OrderCreatedEventDTO {
    private Long id;
    private BigDecimal value = BigDecimal.ZERO;
    private Boolean paid;

    public OrderCreatedEventDTO() {
    }

    public OrderCreatedEventDTO(Long id, BigDecimal value, Boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
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
}