package com.vitorio.cleanarchitecture.infrastructure.persistence.sql;

import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;

public class SqlDataProvider implements DataAccessInterface {

    @Override
    public int saveCalcResult(int result) {
        System.out.println("Saved result " + result + " in SQL database!");
        return result;
    }
}
