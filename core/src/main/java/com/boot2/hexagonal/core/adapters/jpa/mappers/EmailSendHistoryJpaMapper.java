package com.boot2.hexagonal.core.adapters.jpa.mappers;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.id.EmailSendHistoryId;
import com.boot2.hexagonal.core.adapters.jpa.entities.EmailSendHistoryEntity;
import com.boot2.hexagonal.core.domains.EmailSendHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmailSendHistoryJpaMapper extends EmailSendHistoryId.Mapper, EmailAddress.Mapper {

  EmailSendHistoryEntity map(EmailSendHistory emailSendHistory);

  EmailSendHistory map(EmailSendHistoryEntity emailSendHistoryEntity);
}
