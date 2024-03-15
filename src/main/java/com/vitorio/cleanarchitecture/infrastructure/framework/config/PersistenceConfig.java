package com.vitorio.cleanarchitecture.infrastructure.framework.config;

import com.vitorio.cleanarchitecture.infrastructure.persistence.nosql.NoSqlDataProvider;
import com.vitorio.cleanarchitecture.infrastructure.persistence.sql.SqlDataProvider;
import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataAccessInterface dataAccessInterface() {
        return new NoSqlDataProvider();
        //return new SqlDataProvider();
    }
}
