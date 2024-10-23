package com.boot2.hexagonal.core.adapters.redis.configs;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

@Profile("embedded-redis")
@Configuration
public class EmbeddedRedisConfig {

  private final RedisServer redisServer;

  @SneakyThrows
  public EmbeddedRedisConfig(@Value("${spring.redis.port}") int port) {
    this.redisServer = new RedisServer(port);
  }

  @PostConstruct
  public void postConstruct() throws IOException {
    redisServer.start();
  }

  @PreDestroy
  public void preDestroy() throws IOException {
    redisServer.stop();
  }
}
