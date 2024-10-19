package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.EmailSendHistoryCommand;
import com.boot2.hexagonal.core.domain.EmailSendHistory;

public interface EmailSendHistoryMessage {

  record CreateRequest(EmailSendHistoryCommand.CreateRequest request) {}

  record CreateResponse(EmailSendHistory domain) {}
}
