package com.vitorio.cleanarchitecture.usecase;

import com.vitorio.cleanarchitecture.common.usecase.UseCase;
import com.vitorio.cleanarchitecture.usecase.input.InputBoundary;
import com.vitorio.cleanarchitecture.usecase.input.InputData;

public interface UseCaseFactory {
    InputBoundary createUseCase(UseCase useCase, InputData inputData);
}
