package com.vitorio.cleanarchitecture.infrastructure.persistence.nosql;

import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;

public class NoSqlDataProvider implements DataAccessInterface {

    @Override
    public int saveCalcResult(int result) {
        System.out.println("Saved result " + result + " in No-SQL database!");
        return result;
    }
}
