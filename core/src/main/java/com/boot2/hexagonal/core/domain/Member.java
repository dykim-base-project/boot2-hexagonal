package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.MemberStatus;
import com.boot2.hexagonal.api.data.id.MemberId;
import com.boot2.hexagonal.core.domain.message.MemberCreateMessage;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private MemberId id;
  private String email;
  private String password;
  private String name;
  private MemberStatus status;
  private Long signUpAt;
  private Long modifiedAt;

  public static MemberCreateMessage.Response create(MemberCreateMessage.Request messageRequest) {
    var request = messageRequest.request();
    var now = Instant.now().toEpochMilli();
    return new MemberCreateMessage.Response(
        Member.builder()
            .email(request.email())
            .password(request.password())
            .name(request.name())
            .status(MemberStatus.NORMAL)
            .signUpAt(now)
            .modifiedAt(now)
            .build());
  }
}
