package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.command.EmailCommand;
import com.boot2.hexagonal.api.command.EmailSendHistoryCommand;
import com.boot2.hexagonal.api.data.EmailData;
import com.boot2.hexagonal.core.domain.Email;
import com.boot2.hexagonal.core.domain.EmailSendHistory;
import com.boot2.hexagonal.core.domain.message.EmailMessage;
import com.boot2.hexagonal.core.domain.message.EmailSendHistoryMessage;
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
  public EmailData send(EmailCommand.SendRequest request) {
    var messageResponse = Email.send(new EmailMessage.SendRequest(request));
    var email = messageResponse.domain();
    emailPort.send(email);

    var historyCreateCommand =
        EmailSendHistoryCommand.CreateRequest.builder()
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
  public void validate(EmailCommand.ValidateRequest request) {
    var messageResponse = Email.validate(new EmailMessage.ValidateRequest(request));
    var email = messageResponse.domain();
    emailPort.validate(email);
  }
}
