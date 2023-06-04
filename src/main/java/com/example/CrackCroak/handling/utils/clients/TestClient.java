package com.example.CrackCroak.handling.utils.clients;

import com.example.CrackCroak.data.simulations.interactions.BaseInteraction;
import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.data.statistics.BaseStatistics;
import com.example.CrackCroak.data.statistics.results.BaseStepResult;
import reactor.core.publisher.Flux;

public abstract class TestClient {
    protected BaseScenario scenario;

    protected BaseStatistics statistics;

    public TestClient(BaseScenario scenario) {
        this.scenario = scenario;
    }

    public BaseStatistics startScenario() {

        Flux.fromStream(scenario.getSteps().stream())
                .flatMap(this::nextScenarioStep)
                .doOnNext(statistics::registerResult)
                .subscribe();

        return statistics;
    }

    protected abstract Flux<BaseStepResult> nextScenarioStep(BaseInteraction step);
}
