package com.boot2.hexagonal.core


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class CoreTestApplication {
    static void main(String[] args) {
        SpringApplication.run(CoreTestApplication, args)
    }
}
