package com.example.CrackCroak.data.deserializers.simulations;

import com.example.CrackCroak.data.simulations.interactions.BaseInteraction;
import com.example.CrackCroak.data.simulations.requests.SimulationBaseRequest;
import com.example.CrackCroak.data.simulations.responses.SimulationBaseResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

public class BaseInteractionDeserializer extends StdDeserializer<BaseInteraction> {

    private static final TypeReference<MultiValueMap<String,String>> mapType
            = new TypeReference<MultiValueMap<String,String>>() {};
    private static final ObjectMapper mapper = new ObjectMapper();
    public BaseInteractionDeserializer() {

        this(null);
    }

    public BaseInteractionDeserializer(Class<?> vc) {

        super(vc);
    }

    @Override
    public BaseInteraction deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        JsonNode node = jp.getCodec().readTree(jp);

        JsonNode req = node.get("request");
        JsonNode res = node.get("response");
        var headers = mapper.readValue(req.get("headers").textValue(), mapType);
        var cookies = mapper.readValue(req.get("cookies").textValue(), mapType);
        var url = req.get("url").textValue();
        var method = req.get("method").textValue();
        var body = req.get("content").get("text").textValue();
        var request = new SimulationBaseRequest(url, method, headers, cookies, body);
        var response = new SimulationBaseResponse(res.get("status").intValue());

        return new BaseInteraction(request, response);
    }

}
