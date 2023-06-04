package com.example.CrackCroak.handling.utils.clients;

import com.example.CrackCroak.data.simulations.interactions.BaseInteraction;
import com.example.CrackCroak.data.simulations.scenarios.BaseScenario;
import com.example.CrackCroak.data.statistics.BaseStatistics;
import com.example.CrackCroak.data.statistics.results.BaseStepResult;
import com.example.CrackCroak.data.statistics.results.TestResultStatus;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class WebTestClient extends TestClient {

    private WebClient client;

    public WebTestClient(BaseScenario scenario) {
        super(scenario);
        statistics = new BaseStatistics();
    }

    public Flux<BaseStepResult> nextScenarioStep(BaseInteraction step) {

        WebClient c = WebClient.create();
        return c.method(HttpMethod.valueOf(step.getRequest().getMethod()))
                .headers(headers -> headers.addAll(step.getRequest().getHeaders()))
                .cookies(cookies -> cookies.addAll(step.getRequest().getCookies()))
                .body(BodyInserters.fromValue(step.getRequest().getBody()))
                .retrieve().bodyToFlux(ClientResponse.class)
                .elapsed()
                .map(e -> {

                    var time = e.getT1();
                    var response = e.getT2();
                    var status = TestResultStatus.OTHER;

                    if(response.statusCode().is5xxServerError() || response.statusCode().is4xxClientError())
                        status = TestResultStatus.FAIL;
                    else if(response.statusCode().is2xxSuccessful())
                        status = TestResultStatus.SUCCESS;

                    return new BaseStepResult(status, time);
                });
    }
}
