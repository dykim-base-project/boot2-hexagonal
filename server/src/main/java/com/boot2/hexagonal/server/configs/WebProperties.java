package com.boot2.hexagonal.server.configs;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "web")
public class WebProperties {

  private CorsProperties cors;

  @Data
  public static class CorsProperties {
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private long maxAge;
  }
}
