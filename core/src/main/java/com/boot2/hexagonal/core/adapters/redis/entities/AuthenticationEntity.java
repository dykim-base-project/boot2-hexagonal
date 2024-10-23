package com.boot2.hexagonal.core.adapters.redis.entities;

import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@RedisHash(value = "authentication", timeToLive = AuthenticationEntity.TTL)
public class AuthenticationEntity {

  public static final long TTL = 10 * 60L;

  @Id private String id;

  private String type;

  private String code;
}
