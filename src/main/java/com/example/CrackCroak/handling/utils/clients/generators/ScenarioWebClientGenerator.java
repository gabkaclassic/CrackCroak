package com.example.CrackCroak.handling.utils.clients.generators;

import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.handling.utils.clients.WebTestClient;
import com.example.CrackCroak.handling.utils.clients.TestClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class ScenarioWebClientGenerator extends ClientBaseGenerator {

    public ScenarioWebClientGenerator(long amount, BaseScenario scenario) {
        super(amount, scenario);
    }

    public Flux<TestClient> generateClients() {
        return Flux.fromStream(Stream.generate(() -> new WebTestClient(scenario))
                .limit(amount));
    }
}
