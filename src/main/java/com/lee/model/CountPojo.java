package com.lee.model;

import java.math.BigDecimal;

public class CountPojo {
    private String name;
    private BigDecimal ageTotal;

    public CountPojo(String name, BigDecimal ageTotal) {
        this.name = name;
        this.ageTotal = ageTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAgeTotal() {
        return ageTotal;
    }

    public void setAgeTotal(BigDecimal ageTotal) {
        this.ageTotal = ageTotal;
    }
}
