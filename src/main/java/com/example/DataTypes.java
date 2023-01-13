package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import org.immutables.value.Value;

@Value.Immutable
public abstract class DataTypes {

    public static enum TYPE {
        TYPE_1,
        TYPE_2
    }
    
    @JsonbProperty("string")
    public abstract String getString();

    @JsonbProperty("integer")
    public abstract Integer getInteger();

    @JsonbProperty("double")
    public abstract Double getDouble();

    @JsonbProperty("boolean")
    public abstract Boolean isBoolean();

    @JsonbProperty("date")
    public abstract LocalDate getDate();

    @JsonbProperty("dateTime")
    public abstract LocalDateTime getDateTime();

    @JsonbProperty("type")
    public abstract TYPE getType(); 

    @JsonbProperty("list")
    public abstract List<Item> getList();

    @Value.Immutable
    public interface Item {

        @JsonbProperty("property")
        public abstract String getProperty();

        @JsonbProperty("value")
        public abstract String getValue();
    }
}
