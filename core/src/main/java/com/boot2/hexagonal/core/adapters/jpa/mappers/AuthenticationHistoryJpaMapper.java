package com.boot2.hexagonal.core.adapters.jpa.mappers;

import com.boot2.hexagonal.api.data.ids.AuthenticationHistoryId;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import com.boot2.hexagonal.core.adapters.jpa.entities.AuthenticationHistoryEntity;
import com.boot2.hexagonal.core.domains.AuthenticationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthenticationHistoryJpaMapper
    extends AuthenticationHistoryId.Mapper, AuthenticationId.Mapper, WorkerId.Mapper {

  AuthenticationHistoryEntity map(AuthenticationHistory domain);

  AuthenticationHistory map(AuthenticationHistoryEntity entity);
}
