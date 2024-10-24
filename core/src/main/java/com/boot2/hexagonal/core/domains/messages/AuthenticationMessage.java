package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.AuthenticationUserCommand;
import com.boot2.hexagonal.core.domains.Authentication;

public interface AuthenticationMessage {

  record SendCodeToEmailRequest(AuthenticationUserCommand.SendCodeToEmailRequest request) {}

  record SendCodeToEmailResponse(Authentication domain) {}
}
