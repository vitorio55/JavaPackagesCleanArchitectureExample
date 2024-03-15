package com.vitorio.cleanarchitecture.infrastructure.framework.config;

import com.vitorio.cleanarchitecture.infrastructure.externalclient.rest.ExternalRestClient;
import com.vitorio.cleanarchitecture.usecase.boundary.OutputBoundary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalClientsConfig {

    @Bean
    public OutputBoundary externalClient() {
        return new ExternalRestClient();
    }
}
