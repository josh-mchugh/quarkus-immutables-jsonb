package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data-types")
@Produces(MediaType.APPLICATION_JSON)
public class DataTypesResource {
    
    @GET
    public Response getDataTypes() {

        DataTypes.Item firstItem = ImmutableItem.builder()
            .property("property1")
            .value("value1")
            .build();

        DataTypes.Item secondItem = ImmutableItem.builder()
            .property("property2")
            .value("value2")
            .build();

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .string("String Value")
            .integer(1337)
            .getDouble(.999D)
            .isBoolean(Boolean.TRUE)
            .date(LocalDate.parse("2023-01-12", DateTimeFormatter.ISO_DATE))
            .dateTime(LocalDateTime.parse("2023-01-12T12:00:00", DateTimeFormatter.ISO_DATE_TIME))
            .type(DataTypes.TYPE.TYPE_1)
            .addList(firstItem, secondItem)
            .build();

        return Response.ok(dataTypes).build();
    }
}
