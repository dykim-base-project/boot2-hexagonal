package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.EmailCommand;
import com.boot2.hexagonal.core.domain.Email;

public interface EmailMessage {

  record SendRequest(EmailCommand.SendRequest request) {}

  record SendResponse(Email domain) {}

  record ValidateRequest(EmailCommand.ValidateRequest request) {}

  record ValidateResponse(Email domain) {}
}
