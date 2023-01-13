package com.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTypesTest {
    
    @Test
    public void whenDataTypeBasicThenExpectJSON() {

        String expected = "{\"boolean\":false,\"byte\":1,\"character\":\"A\",\"date\":\"2023-01-12\",\"dateTime\":\"2023-01-12T12:00:00\",\"double\":0.9999,\"float\":0.999,\"integer\":1337,\"long\":999,\"short\":1,\"string\":\"String - Test\",\"type\":\"TYPE_2\"}";

        DataTypes.Basic basic = createBasic();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(basic));
    }

    @Test
    public void whenDataTypeSpecificThenExpectJSON() throws MalformedURLException {

        String expected = "{\"bigDecimal\":0.999,\"bigInteger\":1337,\"uri\":\"http://www.quarkus.io\",\"url\":\"http://www.quarkus.io\"}";

        DataTypes.Specific specific = createSpecific();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(specific));
    }

    @Test
    public void whenDataTypeOptionalsThenExpectJSON() {

        String expected = "{\"optional\":\"Hello, Optional\",\"optionalDouble\":0.999,\"optionalInt\":1337,\"optionalLong\":999}";

        DataTypes.Optionals optionals = createOptionals();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(optionals));
    }

    @Test
    public void whenDataTypeEmptyOptionalsThenExpectJSON() {

        String expected = "{}";

        DataTypes.Optionals optionals = createEmptyOptions();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(optionals));

    }

    @Test
    public void whenDataTypesItemThenExpectJSON() {

        String expected = "{\"property\":\"Property - Test\",\"value\":\"Value - Test\"}";

        DataTypes.Item item = createItem();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(item));
    }

    @Test
    public void whenDataTypesExpectJSON() throws MalformedURLException {

        String expected = "{\"basic\":{\"boolean\":false,\"byte\":1,\"character\":\"A\",\"date\":\"2023-01-12\",\"dateTime\":\"2023-01-12T12:00:00\",\"double\":0.9999,\"float\":0.999,\"integer\":1337,\"long\":999,\"short\":1,\"string\":\"String - Test\",\"type\":\"TYPE_2\"},\"list\":[{\"property\":\"Property - Test\",\"value\":\"Value - Test\"}],\"optionals\":{\"optional\":\"Hello, Optional\",\"optionalDouble\":0.999,\"optionalInt\":1337,\"optionalLong\":999},\"specific\":{\"bigDecimal\":0.999,\"bigInteger\":1337,\"uri\":\"http://www.quarkus.io\",\"url\":\"http://www.quarkus.io\"}}";
        
        DataTypes dataTypes = ImmutableDataTypes.builder()
            .basic(createBasic())
            .specific(createSpecific())
            .optionals(createOptionals())
            .addList(createItem())
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(dataTypes));
    }

    private DataTypes.Basic createBasic() {

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
            .date(LocalDate.parse("2023-01-12", DateTimeFormatter.ISO_DATE))
            .dateTime(LocalDateTime.parse("2023-01-12T12:00:00", DateTimeFormatter.ISO_DATE_TIME))
            .type(DataTypes.TYPE.TYPE_2)
            .build();
    }

    public DataTypes.Specific createSpecific() throws MalformedURLException {

        return ImmutableSpecific.builder()
            .bigInteger(new BigInteger("1337"))
            .bigDecimal(new BigDecimal("0.999"))
            .uri(URI.create("http://www.quarkus.io"))
            .url(new URL("http://www.quarkus.io"))
            .build();
    }

    public DataTypes.Optionals createOptionals() {

        return ImmutableOptionals.builder()
            .optional(Optional.of("Hello, Optional"))
            .optionalInt(OptionalInt.of(1337))
            .optionalLong(OptionalLong.of(999L))
            .optionalDouble(OptionalDouble.of(0.999D))
            .build();
    }

    public DataTypes.Optionals createEmptyOptions() {

        return ImmutableOptionals.builder()
            .optional(Optional.empty())
            .optionalInt(OptionalInt.empty())
            .optionalLong(OptionalLong.empty())
            .optionalDouble(OptionalDouble.empty())
            .build();
    }

    private DataTypes.Item createItem() {

        return ImmutableItem.builder()
            .property("Property - Test")
            .value("Value - Test")
            .build();
    }
}
