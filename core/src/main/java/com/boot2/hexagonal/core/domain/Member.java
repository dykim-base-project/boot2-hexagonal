package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberStatus;
import com.boot2.hexagonal.api.data.id.MemberId;
import com.boot2.hexagonal.core.domain.message.MemberCreateMessage;
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
  private MemberStatus status;
  private ZonedDateTime createdAt;
  private ZonedDateTime modifiedAt;

  public static MemberCreateMessage.Response create(MemberCreateMessage.Request messageRequest) {
    var request = messageRequest.request();
    var now = ZonedDateTime.now();
    var response =
        new MemberCreateMessage.Response(
            Member.builder()
                .emailAddress(request.emailAddress())
                .password(request.password())
                .name(request.name())
                .status(MemberStatus.NORMAL)
                .createdAt(now)
                .modifiedAt(now)
                .build());
    log.info("member created: {}", response);
    return response;
  }
}
