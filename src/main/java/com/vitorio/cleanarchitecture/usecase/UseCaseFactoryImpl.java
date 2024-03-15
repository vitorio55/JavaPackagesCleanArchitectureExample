package com.vitorio.cleanarchitecture.usecase;

import com.vitorio.cleanarchitecture.common.usecase.UseCase;
import com.vitorio.cleanarchitecture.domain.CompanyCalculations;
import com.vitorio.cleanarchitecture.domain.CompanyCalculationsFactory;
import com.vitorio.cleanarchitecture.usecase.boundary.InputBoundary;
import com.vitorio.cleanarchitecture.usecase.boundary.OutputBoundary;
import com.vitorio.cleanarchitecture.usecase.data.InputData;
import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;

public class UseCaseFactoryImpl implements UseCaseFactory {

    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary externalClient;

    public UseCaseFactoryImpl(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        this.dataAccessInterface = dataAccessInterface;
        this.externalClient = externalClient;
    }

    @Override
    public InputBoundary createUseCase(UseCase useCase, InputData inputData) {
        if (useCase == UseCase.CALCULATE_COMPANY) {
            CompanyCalculationsFactory ccf = new CompanyCalculationsFactory();
            CompanyCalculations companyCalculations = ccf.createCompanyCalculations(inputData.val0(),
                inputData.val1(), inputData.companyType());
            return new CalculateCompanyUseCase(companyCalculations, dataAccessInterface, externalClient);
        }
        System.out.println("No use case selected!!");
        return null;
    }
}
