package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domain.message.EmailSendMessage;
import com.boot2.hexagonal.core.domain.message.EmailValidateMessage;
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

  private EmailAddress from;
  private EmailAddress to;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  private AuthenticationCode authenticationCode;

  public static EmailSendMessage.Response send(EmailSendMessage.Request message) {
    var request = message.request();
    var email =
        Email.builder()
            .from(request.from())
            .to(request.to())
            .subject(request.subject())
            .body(request.body())
            .sentAt(ZonedDateTime.now())
            .build();
    var response = new EmailSendMessage.Response(email);
    log.info("Email sent: {}", response);
    return response;
  }

  public static EmailValidateMessage.Response validate(EmailValidateMessage.Request message) {
    var request = message.request();
    var email = Email.builder().authenticationCode(request.authenticationCode()).build();
    var response = new EmailValidateMessage.Response(email);
    log.info("Email validated: {}", response);
    return response;
  }
}
