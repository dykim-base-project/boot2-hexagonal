package com.boot2.hexagonal.server.config;

import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  private final WebProperties properties;

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedMethods(
        Optional.ofNullable(properties.getCors().getAllowedMethods())
            .orElse(Collections.emptyList()));
    configuration.setAllowedHeaders(
        Optional.ofNullable(properties.getCors().getAllowedHeaders())
            .orElse(Collections.emptyList()));
    configuration.setMaxAge(Optional.of(properties.getCors().getMaxAge()).orElse(1800L));
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}
