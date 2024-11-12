package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.EmailUserUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.core.configs.EmailFormatProperties;
import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.EmailSendHistory;
import com.boot2.hexagonal.core.domains.mappers.EmailMapper;
import com.boot2.hexagonal.core.domains.messages.EmailMessage;
import com.boot2.hexagonal.core.domains.messages.EmailSendHistoryMessage;
import com.boot2.hexagonal.core.domains.ports.EmailPort;
import com.boot2.hexagonal.core.domains.ports.EmailSendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Service
public class EmailUserService implements EmailUserUseCase {

  private final EmailPort port;
  private final EmailMapper mapper;

  private final EmailSendHistoryRepository emailSendHistoryRepository;

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
    var email = port.send(messageResponse.domain());

    var historyCreateMessageResponse =
        EmailSendHistory.create(new EmailSendHistoryMessage.CreateRequest(email));
    var emailSendHistory = historyCreateMessageResponse.domain();
    emailSendHistoryRepository.create(emailSendHistory);

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
