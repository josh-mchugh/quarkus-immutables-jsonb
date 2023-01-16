package com.example;

import java.net.MalformedURLException;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTypesTest {
    
    @Test
    public void whenDataTypeBasicThenExpectJSON() {

        String expected = "{\"boolean\":false,\"byte\":1,\"character\":\"A\",\"double\":0.9999,\"float\":0.999,\"integer\":1337,\"long\":999,\"short\":1,\"string\":\"String - Test\"}";

        DataTypes.Basic basic = DataTypesFactory.createBasic();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(basic));
    }

    @Test
    public void whenDataTypeSpecificThenExpectJSON() throws MalformedURLException {

        String expected = "{\"bigDecimal\":0.999,\"bigInteger\":1337,\"uri\":\"http://www.quarkus.io\",\"url\":\"http://www.quarkus.io\"}";

        DataTypes.Specific specific = DataTypesFactory.createSpecific();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(specific));
    }

    @Test
    public void whenDataTypeOptionalsThenExpectJSON() {

        String expected = "{\"optional\":\"Hello, Optional\",\"optionalDouble\":0.999,\"optionalInt\":1337,\"optionalLong\":999}";

        DataTypes.Optionals optionals = DataTypesFactory.createOptionals();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(optionals));
    }

    @Test
    public void whenDataTypeEmptyOptionalsThenExpectJSON() {

        String expected = "{}";

        DataTypes.Optionals optionals = DataTypesFactory.createEmptyOptions();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(optionals));
    }

    @Test
    public void whenDataTypeDatesThenExpectJSON() {

        String expected = "{\"calendar\":\"2023-01-14T12:00:00-05:00[America/New_York]\",\"date\":\"2023-01-14T17:00:00Z[UTC]\",\"localDate\":\"2023-01-14\",\"localDateTime\":\"2023-01-14T12:00:00\",\"localTime\":\"12:00:00\"}";

        DataTypes.Dates dates = DataTypesFactory.createDates();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(dates));
    }

    @Test
    public void whenDataTypesEnumerationsThenExpectJSON() {

        String expected = "{\"enumType\":\"TYPE_1\"}";

        DataTypes.Enumeration enumeration = DataTypesFactory.createEnumerations();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(enumeration));
    }

    @Test
    public void whenDataTypesItemThenExpectJSON() {

        String expected = "{\"property\":\"Property - Test\",\"value\":\"Value - Test\"}";

        DataTypes.Item item = DataTypesFactory.createItem();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(item));
    }

    @Test
    public void whenDataTypesExpectJSON() throws MalformedURLException {

        String expected = "{\"basic\":{\"boolean\":false,\"byte\":1,\"character\":\"A\",\"double\":0.9999,\"float\":0.999,\"integer\":1337,\"long\":999,\"short\":1,\"string\":\"String - Test\"},\"dates\":{\"calendar\":\"2023-01-14T12:00:00-05:00[America/New_York]\",\"date\":\"2023-01-14T17:00:00Z[UTC]\",\"localDate\":\"2023-01-14\",\"localDateTime\":\"2023-01-14T12:00:00\",\"localTime\":\"12:00:00\"},\"enumeration\":{\"enumType\":\"TYPE_1\"},\"list\":[{\"property\":\"Property - Test\",\"value\":\"Value - Test\"}],\"optionals\":{\"optional\":\"Hello, Optional\",\"optionalDouble\":0.999,\"optionalInt\":1337,\"optionalLong\":999},\"specific\":{\"bigDecimal\":0.999,\"bigInteger\":1337,\"uri\":\"http://www.quarkus.io\",\"url\":\"http://www.quarkus.io\"}}";

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .basic(DataTypesFactory.createBasic())
            .specific(DataTypesFactory.createSpecific())
            .optionals(DataTypesFactory.createOptionals())
            .dates(DataTypesFactory.createDates())
            .enumeration(DataTypesFactory.createEnumerations())
            .addList(DataTypesFactory.createItem())
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(dataTypes));
    }
}
