package com.example.CrackCroak.handling.utils.clients.generators;

import com.example.CrackCroak.handling.utils.clients.TestClient;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ClientsGenerator {

    Flux<TestClient> generateClients();
}
