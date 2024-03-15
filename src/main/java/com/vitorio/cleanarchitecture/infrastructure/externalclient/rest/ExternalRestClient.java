package com.vitorio.cleanarchitecture.infrastructure.externalclient.rest;

import com.vitorio.cleanarchitecture.usecase.boundary.OutputBoundary;
import com.vitorio.cleanarchitecture.usecase.data.OutputData;

public class ExternalRestClient implements OutputBoundary {

    @Override
    public void interact(OutputData data) {
        System.out.println("Sent data to external REST client! calculationResult=" + data.calculationResult());
    }
}
