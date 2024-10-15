package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.command.EmailSendCommand;
import com.boot2.hexagonal.api.command.EmailSendHistoryCreateCommand;
import com.boot2.hexagonal.api.command.EmailValidateCommand;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.core.domain.Email;
import com.boot2.hexagonal.core.domain.EmailSendHistory;
import com.boot2.hexagonal.core.domain.message.EmailSendHistoryCreateMessage;
import com.boot2.hexagonal.core.domain.message.EmailSendMessage;
import com.boot2.hexagonal.core.domain.message.EmailValidateMessage;
import com.boot2.hexagonal.core.domain.port.EmailPort;
import com.boot2.hexagonal.core.domain.port.EmailSendHistoryRepository;
import com.boot2.hexagonal.core.mapper.EmailMapper;
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

  @Override
  public EmailData send(EmailSendCommand.Request request) {
    var messageResponse = Email.send(new EmailSendMessage.Request(request));
    var email = messageResponse.email();
    emailPort.send(email);

    var historyCreateCommand =
        EmailSendHistoryCreateCommand.Request.builder()
            .from(email.getFrom())
            .to(email.getTo())
            .subject(email.getSubject())
            .body(email.getBody())
            .sentAt(email.getSentAt())
            .build();
    var historyCreateMessageResponse =
        EmailSendHistory.create(new EmailSendHistoryCreateMessage.Request(historyCreateCommand));
    var emailSendHistory = historyCreateMessageResponse.emailSendHistory();
    emailSendHistoryRepository.create(emailSendHistory);

    return emailMapper.map(email);
  }

  @Override
  public void validate(EmailValidateCommand.Request request) {
    var messageResponse = Email.validate(new EmailValidateMessage.Request(request));
    var email = messageResponse.email();
    emailPort.validate(email);
  }
}
