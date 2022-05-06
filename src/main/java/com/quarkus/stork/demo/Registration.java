package com.quarkus.stork.demo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.consul.ConsulClient;

@ApplicationScoped
public class Registration {
    
    @ConfigProperty(name = "consul.host") String host;
    @ConfigProperty(name = "consul.port") int port;

    @ConfigProperty(name = "red-service-port", defaultValue = "9001") int redPort;
    @ConfigProperty(name = "blue-service-port", defaultValue = "9000") int bluePort;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        ConsulClient client = ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(port));

        client.registerServiceAndAwait(new ServiceOptions().setPort(redPort).setAddress("localhost").setName("my-service").setId("red"));
        client.registerServiceAndAwait(new ServiceOptions().setPort(bluePort).setAddress("localhost").setName("my-service").setId("blue"));
    }
}
