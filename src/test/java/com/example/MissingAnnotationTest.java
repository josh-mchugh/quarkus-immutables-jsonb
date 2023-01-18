package com.example;

import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingAnnotationTest {
    
    @Test
    public void whenAnnotationIsMissingThenExpectJSON() {

        String expected = "{\"value\":\"test\"}";

        MissingAnnotation missingAnnotation = ImmutableMissingAnnotation.builder()
            .value("test")
            .build();

        Assertions.assertEquals(expected, JsonbBuilder.create().toJson(missingAnnotation));
    }
}
