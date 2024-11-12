package com.boot2.hexagonal.core.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("email.format")
public class EmailFormatProperties {

  private RequestAuthenticationCode requestAuthenticationCode;

  @Setter
  @Getter
  public static class RequestAuthenticationCode {
    private String subject;
    private String body;
  }
}
