package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.AuthenticationCommand;
import com.boot2.hexagonal.core.domains.Authentication;

public interface AuthenticationMessage {

  record SendCodeToEmailRequest(AuthenticationCommand.SendCodeToEmailRequest request) {}

  record SendCodeToEmailResponse(Authentication domain) {}
}
