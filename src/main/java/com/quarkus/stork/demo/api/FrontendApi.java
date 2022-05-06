package com.quarkus.stork.demo.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.quarkus.stork.demo.client.MyServiceClient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api")
public class FrontendApi {
    
    @Inject @RestClient MyServiceClient service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String invoke() {
        return service.get();
    }
}
