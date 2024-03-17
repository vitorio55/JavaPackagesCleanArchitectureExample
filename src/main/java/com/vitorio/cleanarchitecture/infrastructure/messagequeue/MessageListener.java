package com.vitorio.cleanarchitecture.infrastructure.messagequeue;

import com.vitorio.cleanarchitecture.usecase.input.InputData;

public interface MessageListener {
    void receiveMessage(InputData messageBody);
}
