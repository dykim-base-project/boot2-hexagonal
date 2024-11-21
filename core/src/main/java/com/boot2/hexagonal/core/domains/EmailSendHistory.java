package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.enums.EmailSendTypeKind;
import com.boot2.hexagonal.api.data.ids.EmailSendHistoryId;
import com.boot2.hexagonal.core.domains.messages.EmailSendHistoryMessage.CreateRequest;
import com.boot2.hexagonal.core.domains.messages.EmailSendHistoryMessage.CreateResponse;
import java.time.ZonedDateTime;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendHistory {

  private EmailSendHistoryId id;
  private EmailSendTypeKind sendType;
  private EmailAddress sender;
  private EmailAddress recipient;
  private String subject;
  private String body;
  private ZonedDateTime sentAt;

  public static CreateResponse create(CreateRequest message) {
    var email = message.email();
    var emailSendHistory =
        EmailSendHistory.builder()
            .sendType(email.getSendType())
            .sender(email.getSender())
            .recipient(email.getRecipient())
            .subject(email.getSubject())
            .body(email.getBody())
            .sentAt(email.getSentAt())
            .build();
    var response = new CreateResponse(emailSendHistory);
    log.info("EmailSendHistory created: {}", response);
    return response;
  }
}
