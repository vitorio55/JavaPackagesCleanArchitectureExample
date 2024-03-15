package com.vitorio.cleanarchitecture.infrastructure.framework.config;

import com.vitorio.cleanarchitecture.infrastructure.messagequeue.MessageListener;
import com.vitorio.cleanarchitecture.infrastructure.messagequeue.SqsListener;
import com.vitorio.cleanarchitecture.infrastructure.externalclient.rest.ExternalRestClient;
import com.vitorio.cleanarchitecture.usecase.UseCaseFactory;
import com.vitorio.cleanarchitecture.usecase.persistence.DataAccessInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {

    @Bean
    public MessageListener messageListener(DataAccessInterface dataAccessInterface, ExternalRestClient externalRestClient,
                                           UseCaseFactory factory) {
        return new SqsListener(factory);
    }
}
