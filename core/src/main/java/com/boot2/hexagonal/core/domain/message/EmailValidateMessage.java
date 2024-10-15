package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.EmailValidateCommand;
import com.boot2.hexagonal.core.domain.Email;

public interface EmailValidateMessage {

  record Request(EmailValidateCommand.Request request) {}

  record Response(Email email) {}
}
