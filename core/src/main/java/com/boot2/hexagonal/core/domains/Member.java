package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.enums.MemberStatusKind;
import com.boot2.hexagonal.api.data.ids.MemberId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
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
  private EmailAddress snsEmailAddress;
  private MemberStatusKind status;
  private ZonedDateTime createdAt;
  private WorkerId creatorId;
  private ZonedDateTime modifiedAt;
  private WorkerId modifierId;

  public static CreateResponse create(CreateRequest messageRequest) {
    var request = messageRequest.request();
    var now = ZonedDateTime.now();
    var response =
        new CreateResponse(
            Member.builder()
                .snsEmailAddress(request.snsEmailAddress())
                .status(MemberStatusKind.NORMAL)
                .createdAt(now)
                .creatorId(WorkerId.system())
                .modifiedAt(now)
                .modifierId(WorkerId.system())
                .build());
    log.info("Member created: {}", response);
    return response;
  }
}
