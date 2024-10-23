package com.boot2.hexagonal.core.mappers;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.core.domains.Email;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmailMapper extends EmailAddress.Mapper {
  EmailData map(Email email);
}
