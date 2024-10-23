package com.boot2.hexagonal.core.adapters.redis.mappers;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
import com.boot2.hexagonal.core.adapters.redis.entities.AuthenticationEntity;
import com.boot2.hexagonal.core.domains.Authentication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthenticationRedisRepositoryMapper
    extends AuthenticationId.Mapper, AuthenticationCode.Mapper {

  AuthenticationEntity map(Authentication domain);

  Authentication map(AuthenticationEntity entity);
}
