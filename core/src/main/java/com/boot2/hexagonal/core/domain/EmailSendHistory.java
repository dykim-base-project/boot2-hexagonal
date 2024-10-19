package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.id.EmailSendHistoryId;
import com.boot2.hexagonal.core.domain.message.EmailSendHistoryMessage;
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
  private EmailAddress sender;
  private EmailAddress recipient;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  public static EmailSendHistoryMessage.CreateResponse create(
      EmailSendHistoryMessage.CreateRequest message) {
    var request = message.request();
    var emailSendHistory =
        EmailSendHistory.builder()
            .sender(request.sender())
            .recipient(request.recipient())
            .subject(request.subject())
            .body(request.body())
            .sentAt(request.sentAt())
            .build();
    var response = new EmailSendHistoryMessage.CreateResponse(emailSendHistory);
    log.info("Email send history created: {}", response);
    return response;
  }
}
