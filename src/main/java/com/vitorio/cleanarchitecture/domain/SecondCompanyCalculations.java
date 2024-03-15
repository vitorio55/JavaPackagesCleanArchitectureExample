package com.vitorio.cleanarchitecture.domain;

record SecondCompanyCalculations(int val0, int val1) implements CompanyCalculations {

    @Override
    public int calc() {
        return val0 + val1;
    }
}
