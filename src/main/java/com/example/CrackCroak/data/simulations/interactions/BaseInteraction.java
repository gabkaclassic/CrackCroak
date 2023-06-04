package com.example.CrackCroak.data.simulations.interactions;

import com.example.CrackCroak.data.simulations.requests.SimulationBaseRequest;
import com.example.CrackCroak.data.simulations.responses.SimulationBaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseInteraction {
    protected SimulationBaseRequest request;
    protected SimulationBaseResponse response;
}
