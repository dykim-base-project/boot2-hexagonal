package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.id.EmailSendHistoryId;
import com.boot2.hexagonal.core.domain.message.EmailSendHistoryCreateMessage;
import java.time.ZonedDateTime;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendHistory {

  private EmailSendHistoryId id;
  private EmailAddress from;
  private EmailAddress to;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  public static EmailSendHistoryCreateMessage.Response create(
      EmailSendHistoryCreateMessage.Request message) {
    var request = message.request();
    var emailSendHistory =
        EmailSendHistory.builder()
            .from(request.from())
            .to(request.to())
            .subject(request.subject())
            .body(request.body())
            .sentAt(request.sentAt())
            .build();
    var response = new EmailSendHistoryCreateMessage.Response(emailSendHistory);
    log.info("Email send history created: {}", response);
    return response;
  }
}
