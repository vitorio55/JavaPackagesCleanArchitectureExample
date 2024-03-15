package com.vitorio.cleanarchitecture.usecase;

import com.vitorio.cleanarchitecture.domain.CompanyCalculations;
import com.vitorio.cleanarchitecture.usecase.boundary.InputBoundary;
import com.vitorio.cleanarchitecture.usecase.boundary.OutputBoundary;
import com.vitorio.cleanarchitecture.usecase.data.OutputData;
import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;

public class CalculateCompanyUseCase implements InputBoundary {

    private final CompanyCalculations companyCalculations;
    private final DataAccessInterface dataAccessInterface;
    private final OutputBoundary outputBoundary;

    public CalculateCompanyUseCase(CompanyCalculations companyCalculations, DataAccessInterface dataAccessInterface,
                                   OutputBoundary outputBoundary) {
        this.companyCalculations = companyCalculations;
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public int interact() {
        System.out.println("Calculated: " + companyCalculations.calc());
        int calculated = companyCalculations.calc();
        dataAccessInterface.saveCalcResult(calculated);
        OutputData od = new OutputData(calculated);
        outputBoundary.interact(od);
        return calculated;
    }
}
