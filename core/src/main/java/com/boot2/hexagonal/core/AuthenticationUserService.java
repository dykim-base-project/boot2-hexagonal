package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationUserUseCase;
import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationUserCommand;
import com.boot2.hexagonal.api.commands.AuthenticationUserCommand.SendCodeToEmailRequest;
import com.boot2.hexagonal.api.commands.EmailCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.core.domains.Authentication;
import com.boot2.hexagonal.core.domains.mappers.AuthenticationMapper;
import com.boot2.hexagonal.core.domains.messages.AuthenticationMessage;
import com.boot2.hexagonal.core.domains.ports.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Service
public class AuthenticationUserService implements AuthenticationUserUseCase {

  private final AuthenticationRepository repository;
  private final AuthenticationMapper mapper;

  private final EmailSystemUseCase emailSystemUseCase;

  @Override
  public AuthenticationData sendCodeToEmail(SendCodeToEmailRequest request) {
    var messageResponse =
        Authentication.sendCodeToEmail(new AuthenticationMessage.SendCodeToEmailRequest(request));
    var authentication = repository.create(messageResponse.domain());
    var emailSendRequest =
        EmailCommand.SendRequest.builder()
            .recipient(request.emailAddress())
            .subject("Hexagonal Architecture Project: Authentication Code")
            .body("Your authentication code is " + authentication.getCode())
            .build();
    emailSystemUseCase.send(emailSendRequest);
    return mapper.map(authentication);
  }
}
