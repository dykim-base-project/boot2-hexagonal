package com.boo2.hexagonal.server

import com.boot2.hexagonal.server.config.SecurityConfig
import com.boot2.hexagonal.server.config.WebProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import

@TestConfiguration
@EnableConfigurationProperties([WebProperties])
@Import([SecurityConfig])
class TestConfig {
}