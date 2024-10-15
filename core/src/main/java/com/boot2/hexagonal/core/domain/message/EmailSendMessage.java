package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.EmailSendCommand;
import com.boot2.hexagonal.core.domain.Email;

public interface EmailSendMessage {

  record Request(EmailSendCommand.Request request) {}

  record Response(Email email) {}
}
