package com.trs.springamqp.dtos;

import java.math.BigDecimal;

public class OrderDTO {
    private BigDecimal value = BigDecimal.ZERO;

    public OrderDTO() {
    }

    public OrderDTO(BigDecimal value) {
  
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}