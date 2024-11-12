package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.core.domains.Authentication;

public interface AuthenticationMessage {

  record CreateRequest(AuthenticationSystemCommand.CreateRequest request) {}

  record CreateResponse(Authentication domain) {}

  record ValidateRequest(AuthenticationSystemCommand.ValidateRequest request) {}
}
