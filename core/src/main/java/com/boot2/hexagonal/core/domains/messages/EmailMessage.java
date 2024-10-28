package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.core.domains.Email;
import lombok.Builder;

public interface EmailMessage {

  record SendRequest(EmailSystemCommand.SendRequest request) {}

  record SendResponse(Email domain) {}

  @Builder
  record SendCodeRequest(
      EmailUserCommand.SendCodeRequest request, AuthenticationData authenticationData) {}

  record SendCodeResponse(Email domain) {}
}
