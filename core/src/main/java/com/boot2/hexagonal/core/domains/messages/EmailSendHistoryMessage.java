package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.EmailSendHistoryCommand;
import com.boot2.hexagonal.core.domains.EmailSendHistory;

public interface EmailSendHistoryMessage {

  record CreateRequest(EmailSendHistoryCommand.CreateRequest request) {}

  record CreateResponse(EmailSendHistory domain) {}
}
