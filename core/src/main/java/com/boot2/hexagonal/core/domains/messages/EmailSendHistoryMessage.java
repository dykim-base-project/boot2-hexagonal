package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.EmailSendHistorySystemCommand;
import com.boot2.hexagonal.core.domains.EmailSendHistory;

public interface EmailSendHistoryMessage {

  record CreateRequest(EmailSendHistorySystemCommand.CreateRequest request) {}

  record CreateResponse(EmailSendHistory domain) {}
}
