package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.commands.EmailSendHistorySystemCommand;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
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
public class EmailSystemService implements EmailSystemUseCase {

  private final EmailPort emailPort;
  private final EmailMapper emailMapper;

  private final EmailSendHistoryRepository emailSendHistoryRepository;

  private final AuthenticationSystemUseCase authenticationSystemUseCase;

  @Override
  public EmailData send(EmailSystemCommand.SendRequest request) {
    var messageResponse = Email.send(new EmailMessage.SendRequest(request));
    var email = messageResponse.domain();
    email = emailPort.send(email);

    var historyCreateCommand =
        EmailSendHistorySystemCommand.CreateRequest.builder()
                                                   .sender(email.getSender())
                                                   .recipient(email.getRecipient())
                                                   .subject(email.getSubject())
                                                   .body(email.getBody())
                                                   .sentAt(email.getSentAt())
                                                   .build();
    var historyCreateMessageResponse =
        EmailSendHistory.create(new EmailSendHistoryMessage.CreateRequest(historyCreateCommand));
    var emailSendHistory = historyCreateMessageResponse.domain();
    emailSendHistoryRepository.create(emailSendHistory);

    return emailMapper.map(email);
  }

  @Override
  public void validate(EmailSystemCommand.ValidateRequest request) {
    var authenticationId = AuthenticationId.from(request.emailAddress());
    var validateRequest =
        AuthenticationSystemCommand.ValidateRequest.builder()
            .id(authenticationId)
            .code(request.code())
            .build();
    authenticationSystemUseCase.validate(validateRequest);
  }
}
