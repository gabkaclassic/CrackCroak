package com.example.CrackCroak.handling.utils.emulators;

import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.data.statistics.BaseStatistics;
import com.example.CrackCroak.handling.utils.clients.TestClient;
import com.example.CrackCroak.handling.utils.clients.generators.ClientsGenerator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class ClientsEmulator {

    protected Flux<TestClient> clients;

    ClientsEmulator(ClientsGenerator generator) {
        clients = generator.generateClients();
    }

    abstract ClientsEmulator emulator(long amount, BaseScenario scenario);
    public ClientsEmulator onceUserEmulator(BaseScenario scenario) {
        return emulator(1, scenario);
    }

    abstract Mono<BaseStatistics> startSimulation(BaseScenario scenario, long amountUsers);
}
