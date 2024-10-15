package com.boot2.hexagonal.core.adapter.jpa.mapper;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.id.EmailSendHistoryId;
import com.boot2.hexagonal.core.adapter.jpa.entity.EmailSendHistoryEntity;
import com.boot2.hexagonal.core.domain.EmailSendHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmailSendHistoryJpaMapper extends EmailSendHistoryId.Mapper, EmailAddress.Mapper {

  EmailSendHistoryEntity map(EmailSendHistory emailSendHistory);

  EmailSendHistory map(EmailSendHistoryEntity emailSendHistoryEntity);
}
