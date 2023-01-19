package com.example.modification;

import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Format {
    
    @JsonbDateFormat("dd.MM.yyyy")
    public abstract Date getDate();

    @JsonbNumberFormat("#0.00")
    public abstract BigDecimal getNumber();
}
