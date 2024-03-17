package com.vitorio.cleanarchitecture.infrastructure.framework.config;

import com.vitorio.cleanarchitecture.usecase.UseCaseFactory;
import com.vitorio.cleanarchitecture.usecase.UseCaseFactoryImpl;
import com.vitorio.cleanarchitecture.usecase.output.OutputBoundary;
import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public UseCaseFactory useCaseFactory(DataAccessInterface dataAccessInterface, OutputBoundary externalClient) {
        return new UseCaseFactoryImpl(dataAccessInterface, externalClient);
    }
}
