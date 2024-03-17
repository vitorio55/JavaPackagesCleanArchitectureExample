package com.vitorio.cleanarchitecture.presentation;

import com.vitorio.cleanarchitecture.common.usecase.UseCase;
import com.vitorio.cleanarchitecture.presentation.dto.CalculateCompanyDto;
import com.vitorio.cleanarchitecture.usecase.UseCaseFactory;
import com.vitorio.cleanarchitecture.usecase.input.InputData;

public class CompanyControllerLogicImpl implements CompanyControllerLogic {

    private final UseCaseFactory factory;

    public CompanyControllerLogicImpl(UseCaseFactory factory) {
        this.factory = factory;
    }

    @Override
    public String calculateCompany(CalculateCompanyDto dto) {
        InputData inputData = new InputData(dto.getVal0(), dto.getVal1(), dto.getCompanyType());
        int result = factory
            .createUseCase(UseCase.CALCULATE_COMPANY, inputData)
            .interact();
        return "{ \"result\": " + result + "}";
    }
}
