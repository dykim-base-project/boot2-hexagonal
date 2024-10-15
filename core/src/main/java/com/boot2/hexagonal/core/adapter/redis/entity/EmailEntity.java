package com.boot2.hexagonal.core.adapter.redis.entity;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "emailAddress", timeToLive = EmailEntity.TTL)
public class EmailEntity {

  public static final long TTL = 10 * 60L;
}
