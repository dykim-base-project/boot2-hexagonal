package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.EmailSendHistoryCreateCommand;
import com.boot2.hexagonal.core.domain.EmailSendHistory;

public interface EmailSendHistoryCreateMessage {

  record Request(EmailSendHistoryCreateCommand.Request request) {}

  record Response(EmailSendHistory emailSendHistory) {}
}
