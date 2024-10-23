package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.EmailCommand;
import com.boot2.hexagonal.core.domains.Email;

public interface EmailMessage {

  record SendRequest(EmailCommand.SendRequest request) {}

  record SendResponse(Email domain) {}

  record ValidateRequest(EmailCommand.ValidateRequest request) {}

  record ValidateResponse(Email domain) {}
}
