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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;

import com.example.DataTypes.Enumeration.EnumType;

public class DataTypesFactory {

    private DataTypesFactory() {
        
    }
    
    public static DataTypes.Basic createBasic() {

        return ImmutableBasic.builder()
            .string("String - Test")
            .character('A')
            .getByte((byte) 1)
            .getShort((short) 1)
            .integer(1337)
            .getLong(999L)
            .getFloat(0.999F)
            .getDouble(0.9999D)
            .isBoolean(Boolean.FALSE)
            .build();
    }

    public static DataTypes.Specific createSpecific() throws MalformedURLException {

        return ImmutableSpecific.builder()
            .bigInteger(new BigInteger("1337"))
            .bigDecimal(new BigDecimal("0.999"))
            .uri(URI.create("http://www.quarkus.io"))
            .url(new URL("http://www.quarkus.io"))
            .build();
    }

    public static DataTypes.Optionals createOptionals() {

        return ImmutableOptionals.builder()
            .optional(Optional.of("Hello, Optional"))
            .optionalInt(OptionalInt.of(1337))
            .optionalLong(OptionalLong.of(999L))
            .optionalDouble(OptionalDouble.of(0.999D))
            .build();
    }

    public static DataTypes.Optionals createEmptyOptions() {

        return ImmutableOptionals.builder()
            .optional(Optional.empty())
            .optionalInt(OptionalInt.empty())
            .optionalLong(OptionalLong.empty())
            .optionalDouble(OptionalDouble.empty())
            .build();
    }

    public static DataTypes.Dates createDates() {

        LocalDateTime localDateTime = LocalDateTime.parse("2023-01-14T12:00:00", DateTimeFormatter.ISO_DATE_TIME);
        Date date = Date.from(localDateTime.atZone(ZoneOffset.systemDefault()).toInstant());
        Calendar calendar = GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));

        return ImmutableDates.builder()
            .date(date)
            .calendar(calendar)
            .localTime(LocalTime.from(localDateTime))
            .localDate(LocalDate.from(localDateTime))
            .localDateTime(localDateTime)
            .build();
    }

    public static DataTypes.Enumeration createEnumerations() {

        return ImmutableEnumeration.builder()
            .enumType(EnumType.TYPE_1)
            .build();
    }

    public static DataTypes.Collections createCollections() {

        return ImmutableCollections.builder()
            .listValues(List.of("List Value - 1"))
            .setValues(Set.of("Set Value - 1"))
            .mapValues(Map.of("Key1", "Value - 1"))
            .build();
    }

    public static DataTypes.Collections createCollectionsEmpty() {

        return ImmutableCollections.builder()
            .listValues(List.of())
            .setValues(Set.of())
            .mapValues(Map.of())
            .build();
    }
}
