package com.example.CrackCroak.handling.utils.emulators;

import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.data.statistics.BaseStatistics;
import com.example.CrackCroak.handling.utils.clients.TestClient;
import com.example.CrackCroak.handling.utils.clients.generators.ClientsGenerator;
import com.example.CrackCroak.handling.utils.clients.generators.ScenarioWebClientGenerator;
import reactor.core.publisher.Mono;

public class WebClientsEmulator extends ClientsEmulator {

    private WebClientsEmulator(ClientsGenerator generator) {
        super(generator);
    }

    @Override
    ClientsEmulator emulator(long amount, BaseScenario scenario) {
        return new WebClientsEmulator(new ScenarioWebClientGenerator(amount, scenario));
    }


    public Mono<BaseStatistics> startSimulation(BaseScenario scenario, long amountUsers) {

        return clients
                .map(TestClient::startScenario)
                .reduce(BaseStatistics::joinStatistics);
    }
}
