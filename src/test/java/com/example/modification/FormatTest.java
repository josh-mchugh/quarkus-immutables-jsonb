package com.example.modification;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormatTest {
    
    @Test
    public void whenImmutableThenExpectJSON() throws ParseException {

        String expected = "{\"date\":\"2023-01-18T00:00:00Z[UTC]\",\"number\":123.45678}";

        Format immutable = ImmutableFormat.builder()
            .date(createDate())
            .number(new BigDecimal("123.45678"))
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(immutable));
    }

    @Test
    public void whenPlainJavaThenExpectJSON() throws ParseException {

        String expected = "{\"date\":\"18.01.2023\",\"number\":\"123.46\"}";

        FormatPlain plain = new FormatPlain();
        plain.setDate(createDate());
        plain.setNumber(new BigDecimal("123.45678"));

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(plain));
    }

    private Date createDate() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Etc/UTC")));

        return simpleDateFormat.parse("2023-01-18");
    }
}
