package com.example.type;

import java.net.MalformedURLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data-types")
@Produces(MediaType.APPLICATION_JSON)
public class DataTypesResource {
    
    @GET
    public Response getDataTypes() throws MalformedURLException {

        DataTypes dataTypes = ImmutableDataTypes.builder()
            .basic(DataTypesFactory.createBasic())
            .specific(DataTypesFactory.createSpecific())
            .optionals(DataTypesFactory.createOptionals())
            .dates(DataTypesFactory.createDates())
            .enumeration(DataTypesFactory.createEnumerations())
            .collections(DataTypesFactory.createCollections())
            .build();

        return Response.ok(dataTypes).build();
    }
}
