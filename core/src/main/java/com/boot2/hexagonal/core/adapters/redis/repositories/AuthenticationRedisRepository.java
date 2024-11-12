package com.boot2.hexagonal.core.adapters.redis.repositories;

import com.boot2.hexagonal.core.adapters.redis.entities.AuthenticationEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthenticationRedisRepository
    extends CrudRepository<AuthenticationEntity, String> {}
