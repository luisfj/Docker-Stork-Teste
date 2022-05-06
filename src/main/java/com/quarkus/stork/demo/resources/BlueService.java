package com.quarkus.stork.demo.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.core.Vertx;

@ApplicationScoped
public class BlueService {
    
    @ConfigProperty(name = "blue-service-port", defaultValue = "9000") int port;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        vertx.createHttpServer().requestHandler(req -> req.response().endAndForget("Hello from blue!")).listenAndAwait(port);
    }
}
