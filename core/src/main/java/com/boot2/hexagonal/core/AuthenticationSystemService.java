package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.exceptions.AuthenticationInvalidException;
import com.boot2.hexagonal.api.exceptions.AuthenticationNotFoundException;
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
public class AuthenticationSystemService implements AuthenticationSystemUseCase {

  private final AuthenticationRepository repository;
  private final AuthenticationMapper mapper;

  @Override
  public AuthenticationData create(AuthenticationSystemCommand.CreateRequest request) {
    var messageResponse = Authentication.create(new AuthenticationMessage.CreateRequest(request));
    var authentication = repository.create(messageResponse.domain());
    return mapper.map(authentication);
  }

  @Override
  public void validate(AuthenticationSystemCommand.ValidateRequest request) {
    var authentication =
        repository.findBy(request.id()).orElseThrow(AuthenticationNotFoundException::new);
    var messageResponse =
        authentication.validate(new AuthenticationMessage.ValidateRequest(request));
    if (!messageResponse.isValid()) {
      throw new AuthenticationInvalidException();
    }
  }
}
