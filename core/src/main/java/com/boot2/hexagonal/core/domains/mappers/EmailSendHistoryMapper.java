package com.boot2.hexagonal.core.domains.mappers;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailSendHistoryData;
import com.boot2.hexagonal.api.data.ids.EmailSendHistoryId;
import com.boot2.hexagonal.core.domains.EmailSendHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface EmailSendHistoryMapper extends EmailSendHistoryId.Mapper, EmailAddress.Mapper {

  EmailSendHistoryData map(EmailSendHistory emailSendHistory);
}
