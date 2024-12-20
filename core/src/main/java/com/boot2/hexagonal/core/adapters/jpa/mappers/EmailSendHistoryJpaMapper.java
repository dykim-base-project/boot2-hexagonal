package com.boot2.hexagonal.core.adapters.jpa.mappers;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.ids.EmailSendHistoryId;
import com.boot2.hexagonal.core.adapters.jpa.entities.EmailSendHistoryEntity;
import com.boot2.hexagonal.core.domains.EmailSendHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface EmailSendHistoryJpaMapper extends EmailSendHistoryId.Mapper, EmailAddress.Mapper {

  EmailSendHistoryEntity map(EmailSendHistory emailSendHistory);

  EmailSendHistory map(EmailSendHistoryEntity emailSendHistoryEntity);
}
