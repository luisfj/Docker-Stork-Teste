package com.quarkus.stork.demo.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.core.Vertx;

@ApplicationScoped
public class RedService {
    
    @ConfigProperty(name = "red-service-port", defaultValue = "9001") int port;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        vertx.createHttpServer().requestHandler(req -> req.response().endAndForget("Hello from Red!")).listenAndAwait(port);
    }
}
