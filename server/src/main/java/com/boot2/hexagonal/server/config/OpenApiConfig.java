package com.boot2.hexagonal.server.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer")
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .servers(List.of(new Server().url("/")))
        .components(new Components())
        .info(apiInfo());
  }

  private Info apiInfo() {
    return new Info()
        .title("Hexagonal Boot2 Server")
        .description("Hexagonal Boot2 Open API 3.0 Docs")
        .version("1.0.0");
  }
}
