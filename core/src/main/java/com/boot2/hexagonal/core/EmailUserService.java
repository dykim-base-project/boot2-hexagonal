package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.EmailUserUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.api.data.enums.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.core.configs.EmailFormatProperties;
import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.messages.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Service
public class EmailUserService implements EmailUserUseCase {

  private final EmailSystemUseCase emailSystemUseCase;

  private final AuthenticationSystemUseCase authenticationSystemUseCase;

  private final EmailFormatProperties formatProperties;

  @Override
  public EmailData sendCode(EmailUserCommand.SendCodeRequest request) {
    var createRequest =
        AuthenticationSystemCommand.CreateRequest.builder()
            .id(AuthenticationId.from(request.emailAddress()))
            .type(AuthenticationTypeKind.EMAIL)
            .build();
    var authenticationData = authenticationSystemUseCase.create(createRequest);

    var messageResponse =
        Email.sendCode(
            new EmailMessage.SendCodeRequest(request, authenticationData, formatProperties));
    var email = messageResponse.domain();
    var sendRequest =
        EmailSystemCommand.SendRequest.builder()
            .sendType(email.getSendType())
            .subject(email.getSubject())
            .recipient(email.getRecipient())
            .body(email.getBody())
            .build();
    return emailSystemUseCase.send(sendRequest);
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
