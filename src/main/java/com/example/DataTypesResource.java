package com.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.DataTypes.Enumeration.EnumType;

@Path("/data-types")
@Produces(MediaType.APPLICATION_JSON)
public class DataTypesResource {
    
    @GET
    public Response getDataTypes() throws MalformedURLException {

        DataTypes.Item firstItem = ImmutableItem.builder()
            .property("property1")
            .value("value1")
            .build();

        DataTypes.Item secondItem = ImmutableItem.builder()
            .property("property2")
            .value("value2")
            .build();

        DataTypes.Basic basic = ImmutableBasic.builder()
            .string("String Value")
            .character('A')
            .getByte((byte) 1)
            .getShort((short) 1)
            .integer(1337)
            .getLong(999L)
            .getFloat(0.999F)
            .getDouble(0.999D)
            .isBoolean(Boolean.TRUE)
            .build();

        DataTypes.Specific specific = ImmutableSpecific.builder()
            .bigInteger(new BigInteger("1337"))
            .bigDecimal(new BigDecimal(".9999"))
            .uri(URI.create("http://www.quarkus.io"))
            .url(new URL("http://www.quarkus.io"))
            .build();

        DataTypes.Optionals optionals = ImmutableOptionals.builder()
            .optional(Optional.of("Hello, Optional"))
            .optionalInt(OptionalInt.of(1337))
            .optionalLong(OptionalLong.of(9999L))
            .optionalDouble(OptionalDouble.of(.999D))
            .build();

        LocalDateTime localDateTime = LocalDateTime.parse("2023-01-14T12:00:00", DateTimeFormatter.ISO_DATE_TIME);
        Date date = Date.from(localDateTime.atZone(ZoneOffset.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));
    
        ImmutableDates dates = ImmutableDates.builder()
                .date(date)
                .calendar(calendar)
                .localTime(LocalTime.from(localDateTime))
                .localDate(LocalDate.from(localDateTime))
                .localDateTime(localDateTime)
                .build();

        ImmutableEnumeration enumeration = ImmutableEnumeration.builder()
            .enumType(EnumType.TYPE_1)
            .build();

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .basic(basic)
            .specific(specific)
            .optionals(optionals)
            .dates(dates)
            .enumeration(enumeration)
            .addList(firstItem, secondItem)
            .build();

        return Response.ok(dataTypes).build();
    }
}
