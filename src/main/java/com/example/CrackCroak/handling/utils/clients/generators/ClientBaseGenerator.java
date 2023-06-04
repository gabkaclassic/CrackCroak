package com.example.CrackCroak.handling.utils.clients.generators;

import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;

public abstract class ClientBaseGenerator implements ClientsGenerator {

    protected long amount;

    protected BaseScenario scenario;

    public ClientBaseGenerator(long amount, BaseScenario scenario) {
        this.amount = amount;
        this.scenario = scenario;
    }
}
