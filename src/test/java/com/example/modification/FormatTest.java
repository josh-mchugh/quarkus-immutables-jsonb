package com.example.modification;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormatTest {
    
    @Test
    public void whenImmutableThenExpectJSON() throws ParseException {

        String expected = "{\"date\":\"2023-01-18T05:00:00Z[UTC]\",\"number\":123.45678}";

        Format immutable = ImmutableFormat.builder()
            .date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-18"))
            .number(new BigDecimal("123.45678"))
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(immutable));
    }

    @Test
    public void whenPlainJavaThenExpectJSON() throws ParseException {

        String expected = "{\"date\":\"18.01.2023\",\"number\":\"123.46\"}";

        FormatPlain plain = new FormatPlain();
        plain.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-18"));
        plain.setNumber(new BigDecimal("123.45678"));

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(plain));
    }
}
