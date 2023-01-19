package com.example.modification;

import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;

public class FormatPlain {
    
    @JsonbDateFormat("dd.MM.yyyy")
    private Date date;

    @JsonbNumberFormat("#0.00")
    private BigDecimal number;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }
}
