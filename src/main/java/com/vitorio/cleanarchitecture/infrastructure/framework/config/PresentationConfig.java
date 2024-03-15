package com.vitorio.cleanarchitecture.infrastructure.framework.config;

import com.vitorio.cleanarchitecture.presentation.CompanyControllerLogic;
import com.vitorio.cleanarchitecture.presentation.CompanyControllerLogicImpl;
import com.vitorio.cleanarchitecture.usecase.UseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentationConfig {

    @Bean
    public CompanyControllerLogic controllerLogic(UseCaseFactory factory) {
        return new CompanyControllerLogicImpl(factory);
    }
}
