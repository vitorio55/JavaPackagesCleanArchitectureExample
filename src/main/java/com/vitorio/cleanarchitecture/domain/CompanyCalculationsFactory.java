package com.vitorio.cleanarchitecture.domain;

import com.vitorio.cleanarchitecture.common.domain.CompanyType;

public class CompanyCalculationsFactory {

    public CompanyCalculations createCompanyCalculations(int val0, int val1, CompanyType companyType) {
        return switch (companyType) {
            case FIRST -> new FirstCompanyCalculations(val0, val1);
            case SECOND -> new SecondCompanyCalculations(val0, val1);
        };
    }
}
