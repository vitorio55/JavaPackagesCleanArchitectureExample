package com.vitorio.cleanarchitecture.usecase;

import com.vitorio.cleanarchitecture.common.usecase.UseCase;
import com.vitorio.cleanarchitecture.usecase.boundary.InputBoundary;
import com.vitorio.cleanarchitecture.usecase.data.InputData;

public interface UseCaseFactory {
    InputBoundary createUseCase(UseCase useCase, InputData inputData);
}
