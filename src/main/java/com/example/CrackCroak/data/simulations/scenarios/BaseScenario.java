package com.example.CrackCroak.data.simulations.scenarios;

import com.example.CrackCroak.data.deserializers.simulations.BaseScenarioDeserializer;
import com.example.CrackCroak.data.simulations.interactions.BaseInteraction;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(using = BaseScenarioDeserializer.class)
public class BaseScenario {

    protected List<BaseInteraction> steps;

    protected TypeSimulation type;

    public BaseScenario(List<BaseInteraction> steps) {
        this.steps = steps;
    }
}
