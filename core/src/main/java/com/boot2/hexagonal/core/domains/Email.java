package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domains.messages.EmailMessage;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.SendCodeRequest;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.SendRequest;
import com.boot2.hexagonal.core.domains.messages.EmailMessage.SendResponse;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

  public static EmailMessage.SendCodeResponse sendCode(SendCodeRequest message) {
    var request = message.request();
    var authenticationData = message.authenticationData();
    var format = message.formatProperties().getRequestAuthenticationCode();
    var body = format.getBody().replace("${authenticationCode}", authenticationData.code().value());
    var email =
        Email.builder()
            .recipient(request.emailAddress())
            .subject(format.getSubject())
            .body(body)
            .sentAt(ZonedDateTime.now())
            .build();
    log.info("Send code: {}", email);
    return new EmailMessage.SendCodeResponse(email);
  }
}
