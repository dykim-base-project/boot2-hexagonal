package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.EmailSystemUseCase
import org.mockito.Mockito
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestConfig {

    @ConditionalOnMissingBean
    @Bean
    static EmailSystemUseCase emailSystemUseCase() {
        return Mockito.mock(EmailSystemUseCase.class)
    }
}
