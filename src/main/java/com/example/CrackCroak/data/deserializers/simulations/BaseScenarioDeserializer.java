package com.example.CrackCroak.data.deserializers.simulations;

import com.example.CrackCroak.data.simulations.interactions.BaseInteraction;
import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.handling.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class BaseScenarioDeserializer extends StdDeserializer<BaseScenario> {

    public BaseScenarioDeserializer() {

        this(null);
    }

    public BaseScenarioDeserializer(Class<?> vc) {

        super(vc);
    }

    @Override
    public BaseScenario deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        JsonNode node = jp.getCodec().readTree(jp);
        var interactions = JsonUtils.splitObjects(node, "entries", BaseInteraction.class).toList();

        return new BaseScenario(interactions);
    }

}
