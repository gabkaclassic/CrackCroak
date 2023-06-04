package com.example.CrackCroak.data.statistics.results;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseStepResult {

    protected TestResultStatus status;
    protected long duration;
}
