package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.EmailUserUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.mappers.EmailMapper;
import com.boot2.hexagonal.core.domains.messages.EmailMessage;
import com.boot2.hexagonal.core.domains.ports.EmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Service
public class EmailUserService implements EmailUserUseCase {

  private final EmailPort port;
  private final EmailMapper mapper;

  private final AuthenticationSystemUseCase authenticationSystemUseCase;

  @Override
  public EmailData sendCode(EmailUserCommand.SendCodeRequest request) {
    var createRequest =
        AuthenticationSystemCommand.CreateRequest.builder()
            .id(AuthenticationId.from(request.emailAddress()))
            .build();
    var authenticationData = authenticationSystemUseCase.create(createRequest);
    var messageResponse =
        Email.sendCode(new EmailMessage.SendCodeRequest(request, authenticationData));
    var email = port.send(messageResponse.domain());
    return mapper.map(email);
  }

  @Override
  public void validate(EmailUserCommand.ValidateRequest request) {
    var authenticationId = AuthenticationId.from(request.emailAddress());
    var validateRequest =
        AuthenticationSystemCommand.ValidateRequest.builder()
            .id(authenticationId)
            .code(request.code())
            .build();
    authenticationSystemUseCase.validate(validateRequest);
  }
}
