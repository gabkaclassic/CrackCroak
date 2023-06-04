package com.example.CrackCroak.data.simulations.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.MultiValueMap;

@Data
@AllArgsConstructor
public class SimulationBaseRequest {

    private String url;
    private String method;
    private MultiValueMap<String, String> headers;
    private MultiValueMap<String, String> cookies;
    private String body;
}
