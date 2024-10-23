package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberStatusKind;
import com.boot2.hexagonal.api.data.id.MemberId;
import com.boot2.hexagonal.core.domains.messages.MemberMessage.CreateRequest;
import com.boot2.hexagonal.core.domains.messages.MemberMessage.CreateResponse;
import java.time.ZonedDateTime;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private MemberId id;
  private EmailAddress emailAddress;
  private boolean emailValidated;
  private String password;
  private String name;
  private MemberStatusKind status;
  private ZonedDateTime createdAt;
  private ZonedDateTime modifiedAt;

  public static CreateResponse create(CreateRequest messageRequest) {
    var request = messageRequest.request();
    var now = ZonedDateTime.now();
    var response =
        new CreateResponse(
            Member.builder()
                .emailAddress(request.emailAddress())
                .password(request.password())
                .name(request.name())
                .status(MemberStatusKind.NORMAL)
                .createdAt(now)
                .modifiedAt(now)
                .build());
    log.info("domain created: {}", response);
    return response;
  }
}
