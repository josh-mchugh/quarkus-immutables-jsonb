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
                .body("string", is("String Value"))
                .body("integer", is(1337))
                .body("double", is(.999F))
                .body("boolean", is(true))
                .body("date", is("2023-01-12"))
                .body("dateTime", is("2023-01-12T12:00:00"))
                .body("type", is("TYPE_1"))
                .body("list.size()", is(2))
                .body("list[0].property", is("property1"))
                .body("list[0].value", is("value1"))
                .body("list[1].property", is("property2"))
                .body("list[1].value", is("value2"));
    }
}
