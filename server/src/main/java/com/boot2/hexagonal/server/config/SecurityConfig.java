package com.boot2.hexagonal.server.config;

import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(AbstractHttpConfigurer::disable);
    http.csrf(AbstractHttpConfigurer::disable);
    http.cors();
    http.headers().frameOptions().sameOrigin();
    http.exceptionHandling(
        handling -> {
          handling.authenticationEntryPoint(
              (request, response, exception) ->
                  response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
          handling.accessDeniedHandler(
              (request, response, exception) ->
                  response.sendError(HttpServletResponse.SC_FORBIDDEN));
        });
    return http.build();
  }
}
