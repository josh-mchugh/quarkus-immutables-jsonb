package com.example;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.Response;

@QuarkusTest
public class DataTypesResourceTest {

    @Test
    public void testDataTypesEndpoint() {
        given()
            .when().get("/data-types")
            .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("basic.string", is("String Value"))
                .body("basic.character", is("A"))
                .body("basic.byte", is(1))
                .body("basic.short", is(1))
                .body("basic.integer", is(1337))
                .body("basic.long", is(999))
                .body("basic.float", is(0.999F))
                .body("basic.double", is(0.999F))
                .body("basic.boolean", is(true))
                .body("basic.date", is("2023-01-12"))
                .body("basic.dateTime", is("2023-01-12T12:00:00"))
                .body("basic.type", is("TYPE_1"))
                .body("specific.bigInteger", is(1337))
                .body("specific.bigDecimal", is(0.9999F))
                .body("specific.uri", is("http://www.quarkus.io"))
                .body("specific.url", is("http://www.quarkus.io"))
                .body("optionals.optional", is("Hello, Optional"))
                .body("optionals.optionalInt", is(1337))
                .body("optionals.optionalLong", is(9999))
                .body("optionals.optionalDouble", is(0.999F))
                .body("list.size()", is(2))
                .body("list[0].property", is("property1"))
                .body("list[0].value", is("value1"))
                .body("list[1].property", is("property2"))
                .body("list[1].value", is("value2"));
    }
}
