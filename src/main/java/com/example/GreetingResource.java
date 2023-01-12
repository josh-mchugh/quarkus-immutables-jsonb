package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {

    Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        Greeting greeting = ImmutableGreeting.builder()
            .message("Hello from RESTEasy Reactive")
            .build();

        return Response.ok(greeting).build();
    }
}