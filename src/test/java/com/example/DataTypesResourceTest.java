package com.example;


import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasKey;

import javax.ws.rs.core.Response;

@QuarkusTest
public class DataTypesResourceTest {

    @Test
    public void testDataTypesEndpoint() {
        given()
            .when().get("/data-types")
            .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("basic.string", is("String - Test"))
                .body("basic.character", is("A"))
                .body("basic.byte", is(1))
                .body("basic.short", is(1))
                .body("basic.integer", is(1337))
                .body("basic.long", is(999))
                .body("basic.float", is(0.999F))
                .body("basic.double", is(0.9999F))
                .body("basic.boolean", is(false))
                .body("specific.bigInteger", is(1337))
                .body("specific.bigDecimal", is(0.999F))
                .body("specific.uri", is("http://www.quarkus.io"))
                .body("specific.url", is("http://www.quarkus.io"))
                .body("optionals.optional", is("Hello, Optional"))
                .body("optionals.optionalInt", is(1337))
                .body("optionals.optionalLong", is(999))
                .body("optionals.optionalDouble", is(0.999F))
                .body("dates.date", is("2023-01-14T17:00:00Z[UTC]"))
                .body("dates.calendar", is("2023-01-14T12:00:00-05:00[America/New_York]"))
                .body("dates.localTime", is("12:00:00"))
                .body("dates.localDate", is("2023-01-14"))
                .body("dates.localDateTime", is("2023-01-14T12:00:00"))
                .body("enumeration.enumType", is("TYPE_1"))
                .body("collections.listValues.size()", is(1))
                .body("collections.listValues[0]", is("List Value - 1"))
                .body("collections.setValues.size()", is(1))
                .body("collections.setValues[0]", is("Set Value - 1"))
                .body("collections.mapValues.size()", is(1))
                .body("collections.mapValues", hasKey("Key1"))
                .body("collections.mapValues.Key1", is("Value - 1"));
    }
}
