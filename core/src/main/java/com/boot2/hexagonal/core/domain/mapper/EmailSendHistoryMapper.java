package com.boot2.hexagonal.core.domain.mapper;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailSendHistoryData;
import com.boot2.hexagonal.api.data.id.EmailSendHistoryId;
import com.boot2.hexagonal.core.domain.EmailSendHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmailSendHistoryMapper extends EmailSendHistoryId.Mapper, EmailAddress.Mapper {

  EmailSendHistoryData map(EmailSendHistory emailSendHistory);
}
