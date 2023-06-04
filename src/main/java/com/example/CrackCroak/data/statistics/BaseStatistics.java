package com.example.CrackCroak.data.statistics;

import com.example.CrackCroak.data.statistics.results.BaseStepResult;

public class BaseStatistics {

    private long generalAmount;
    private long failsAmount;
    private long successAmount;
    private long otherAmount;
    private long generalDuration;

    public void registerResult(BaseStepResult result) {

        generalAmount++;

        switch (result.getStatus()) {

            case SUCCESS -> successAmount++;
            case FAIL -> failsAmount++;
            case OTHER -> otherAmount++;
        }
        generalDuration += result.getDuration();
    }

    public synchronized BaseStatistics joinStatistics(BaseStatistics joined) {
        generalAmount += joined.generalAmount;
        successAmount += joined.successAmount;
        failsAmount += joined.failsAmount;
        otherAmount += joined.otherAmount;
        generalDuration += joined.generalDuration;

        return this;
    }
}
