package com.example;

import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataTypesTest {
    
    JsonbConfig config;
    Jsonb jsonb;

    @BeforeEach
    public void setup() {

        config = new JsonbConfig().withFormatting(true);
        jsonb = JsonbBuilder.create(config);
    }

    @Test
    public void whenDataTypeBasicThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-basic.json");

        DataTypes.Basic basic = DataTypesFactory.createBasic();        

        Assertions.assertEquals(expected, jsonb.toJson(basic));
    }

    @Test
    public void whenDataTypeSpecificThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-specific.json");

        DataTypes.Specific specific = DataTypesFactory.createSpecific();

        Assertions.assertEquals(expected, jsonb.toJson(specific));
    }

    @Test
    public void whenDataTypeOptionalsThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-optionals.json");

        DataTypes.Optionals optionals = DataTypesFactory.createOptionals();

        Assertions.assertEquals(expected, jsonb.toJson(optionals));
    }

    @Test
    public void whenDataTypeOptionalsEmptyThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-optionals-empty.json");

        DataTypes.Optionals optionals = DataTypesFactory.createEmptyOptions();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(optionals));
    }

    @Test
    public void whenDataTypeDatesThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-dates.json");

        DataTypes.Dates dates = DataTypesFactory.createDates();

        Assertions.assertEquals(expected, jsonb.toJson(dates));
    }

    @Test
    public void whenDataTypesEnumerationsThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-enumerations.json");

        DataTypes.Enumeration enumeration = DataTypesFactory.createEnumerations();

        Assertions.assertEquals(expected, jsonb.toJson(enumeration));
    }

    @Test
    public void whenDataTypesCollectionsThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-collections.json");

        DataTypes.Collections collections = DataTypesFactory.createCollections();

        Assertions.assertEquals(expected, jsonb.toJson(collections));
    }

    @Test
    public void whenDataTypesCollectionsEmptyThenExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types-collections-empty.json");

        DataTypes.Collections collections = DataTypesFactory.createCollectionsEmpty();

        Assertions.assertEquals(expected, jsonb.toJson(collections));
    }

    @Test
    public void whenDataTypesExpectJSON() throws IOException {

        String expected = new JsonFileUtils().getJsonFromFile("data-types.json");

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .basic(DataTypesFactory.createBasic())
            .specific(DataTypesFactory.createSpecific())
            .optionals(DataTypesFactory.createOptionals())
            .dates(DataTypesFactory.createDates())
            .enumeration(DataTypesFactory.createEnumerations())
            .collections(DataTypesFactory.createCollections())
            .build();

        Assertions.assertEquals(expected, jsonb.toJson(dataTypes));
    }
}
