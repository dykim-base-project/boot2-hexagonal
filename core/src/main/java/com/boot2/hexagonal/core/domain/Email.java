package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domain.message.EmailMessage;
import java.time.ZonedDateTime;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {

  private EmailAddress sender;
  private EmailAddress recipient;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  private AuthenticationCode authenticationCode;

  public static EmailMessage.SendResponse send(EmailMessage.SendRequest message) {
    var request = message.request();
    var email =
        Email.builder()
            .sender(request.from())
            .recipient(request.to())
            .subject(request.subject())
            .body(request.body())
            .sentAt(ZonedDateTime.now())
            .build();
    var response = new EmailMessage.SendResponse(email);
    log.info("Email sent: {}", response);
    return response;
  }

  public static EmailMessage.ValidateResponse validate(EmailMessage.ValidateRequest message) {
    var request = message.request();
    var email = Email.builder().authenticationCode(request.authenticationCode()).build();
    var response = new EmailMessage.ValidateResponse(email);
    log.info("Email validated: {}", response);
    return response;
  }
}
