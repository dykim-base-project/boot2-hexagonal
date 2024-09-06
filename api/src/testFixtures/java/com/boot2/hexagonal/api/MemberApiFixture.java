package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.MemberCreateCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.MemberStatus;
import com.boot2.hexagonal.api.data.id.MemberId;

public interface MemberApiFixture {
  MemberId ID_NORMAL = MemberId.from(1L);
  MemberCreateCommand.Request COMMAND_CREATE =
      MemberCreateCommand.Request.builder()
          .name("name")
          .email("request@email.com")
          .authenticationCode(AuthenticationCode.from("test"))
          .password("password")
          .build();

  MemberData DATA_CREATED_NORMAL =
      MemberData.builder()
          .id(ID_NORMAL)
          .email(COMMAND_CREATE.email())
          .name(COMMAND_CREATE.name())
          .status(MemberStatus.NORMAL)
          .build();
}
