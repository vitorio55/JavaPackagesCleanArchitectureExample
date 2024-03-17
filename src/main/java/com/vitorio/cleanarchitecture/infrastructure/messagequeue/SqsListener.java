package com.vitorio.cleanarchitecture.infrastructure.messagequeue;

import com.vitorio.cleanarchitecture.common.domain.CompanyType;
import com.vitorio.cleanarchitecture.common.usecase.UseCase;
import com.vitorio.cleanarchitecture.usecase.UseCaseFactory;
import com.vitorio.cleanarchitecture.usecase.input.InputData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SqsListener implements MessageListener {

    private static final int SQS_MESSAGES_ARRIVAL_SECONDS = 30;
    private final UseCaseFactory factory;

    public SqsListener(UseCaseFactory factory) {
        // Mocks the arrival of SQS messages every X seconds
        this.factory = factory;
        InputData messageBody = new InputData(9, 9, CompanyType.FIRST);
        Runnable sqsMessageArrival = () -> receiveMessage(messageBody);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(sqsMessageArrival, 15, SQS_MESSAGES_ARRIVAL_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public void receiveMessage(InputData messageBody) {
        UseCase uc = UseCase.CALCULATE_COMPANY;
        System.out.println("SQS Listener will execute " + uc.name() + " use case");
        factory.createUseCase(uc, messageBody).interact();
    }
}
