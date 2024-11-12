package com.boot2.hexagonal.server

import com.boot2.hexagonal.server.configs.SecurityConfig
import com.boot2.hexagonal.server.configs.WebProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import

@TestConfiguration
@EnableConfigurationProperties([WebProperties])
@Import([SecurityConfig])
class TestConfig {
}