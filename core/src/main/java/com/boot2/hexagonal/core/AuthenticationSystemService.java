package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import com.boot2.hexagonal.api.exceptions.AuthenticationNotFoundException;
import com.boot2.hexagonal.core.domains.Authentication;
import com.boot2.hexagonal.core.domains.AuthenticationHistory;
import com.boot2.hexagonal.core.domains.mappers.AuthenticationMapper;
import com.boot2.hexagonal.core.domains.messages.AuthenticationHistoryMessage;
import com.boot2.hexagonal.core.domains.messages.AuthenticationMessage;
import com.boot2.hexagonal.core.domains.ports.AuthenticationHistoryRepository;
import com.boot2.hexagonal.core.domains.ports.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Service
public class AuthenticationSystemService implements AuthenticationSystemUseCase {

  private final AuthenticationRepository repository;
  private final AuthenticationMapper mapper;

  private final AuthenticationHistoryRepository historyRepository;

  @Transactional
  @Override
  public AuthenticationData create(AuthenticationSystemCommand.CreateRequest request) {
    var messageResponse = Authentication.create(new AuthenticationMessage.CreateRequest(request));
    var authentication = repository.create(messageResponse.domain());

    var historyMessageResponse =
        AuthenticationHistory.create(
            AuthenticationHistoryMessage.CreateRequest.from(
                authentication, WorkerId.system(), false));
    historyRepository.create(historyMessageResponse.domain());
    return mapper.map(authentication);
  }

  @Override
  public void validate(AuthenticationSystemCommand.ValidateRequest request) {
    var authentication =
        repository.findBy(request.id()).orElseThrow(AuthenticationNotFoundException::new);
    authentication.validate(new AuthenticationMessage.ValidateRequest(request));

    var historyMessageResponse =
        AuthenticationHistory.create(
            AuthenticationHistoryMessage.CreateRequest.from(
                authentication, WorkerId.system(), true));
    historyRepository.create(historyMessageResponse.domain());
  }
}
