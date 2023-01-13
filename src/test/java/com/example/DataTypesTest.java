package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTypesTest {

    @Test
    public void whenConvertedToJsonExpectValue() {

        String expected = "{\"boolean\":false,\"date\":\"2023-01-12\",\"dateTime\":\"2023-01-12T12:00:00\",\"double\":0.9999,\"integer\":1337,\"list\":[{\"property\":\"Property - Test\",\"value\":\"Value - Test\"}],\"string\":\"String - Test\",\"type\":\"TYPE_2\"}";

        DataTypes.Item item = ImmutableItem.builder()
            .property("Property - Test")
            .value("Value - Test")
            .build();

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .string("String - Test")
            .integer(1337)
            .getDouble(0.9999D)
            .isBoolean(Boolean.FALSE)
            .date(LocalDate.parse("2023-01-12", DateTimeFormatter.ISO_DATE))
            .dateTime(LocalDateTime.parse("2023-01-12T12:00:00", DateTimeFormatter.ISO_DATE_TIME))
            .type(DataTypes.TYPE.TYPE_2)
            .addList(item)
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(dataTypes));
    }
}
