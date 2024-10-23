package com.boot2.hexagonal.core.domains.mappers;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
import com.boot2.hexagonal.core.domains.Authentication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthenticationMapper extends AuthenticationId.Mapper, AuthenticationCode.Mapper {

  AuthenticationData map(Authentication authenticationData);
}
