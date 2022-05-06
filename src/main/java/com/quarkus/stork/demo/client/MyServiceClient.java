package com.quarkus.stork.demo.client;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "stork://my-service")
public interface MyServiceClient {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
}
