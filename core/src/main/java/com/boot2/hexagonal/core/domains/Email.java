package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.SendRequest;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.SendResponse;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.ValidateRequest;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.ValidateResponse;
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

  private EmailAddress recipient;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  @Setter private EmailAddress sender;

  private AuthenticationCode authenticationCode;

  public static SendResponse send(SendRequest message) {
    var request = message.request();
    var email =
        Email.builder()
            .recipient(request.recipient())
            .subject(request.subject())
            .body(request.body())
            .sentAt(ZonedDateTime.now())
            .build();
    var response = new SendResponse(email);
    log.info("Email sent: {}", response);
    return response;
  }

  public static ValidateResponse validate(ValidateRequest message) {
    var request = message.request();
    var email = Email.builder().authenticationCode(request.authenticationCode()).build();
    var response = new ValidateResponse(email);
    log.info("Email validated: {}", response);
    return response;
  }
}
