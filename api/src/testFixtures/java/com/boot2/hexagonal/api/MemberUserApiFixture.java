package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.MemberStatusKind;
import com.boot2.hexagonal.api.data.ids.MemberId;
import java.time.ZonedDateTime;

public interface MemberUserApiFixture {
  MemberId ID_NORMAL = MemberId.from(1L);
  ZonedDateTime NOW = ZonedDateTime.now();
  MemberUserCommand.CreateRequest COMMAND_CREATE =
      MemberUserCommand.CreateRequest.builder()
          .name("name")
          .emailAddress(EmailAddress.from("request@emailAddress.com"))
          .code(AuthenticationCode.from("test"))
          .password("password")
          .build();

  MemberData DATA_CREATED_NORMAL =
      MemberData.builder()
          .id(ID_NORMAL)
          .emailAddress(COMMAND_CREATE.emailAddress())
          .name(COMMAND_CREATE.name())
          .status(MemberStatusKind.NORMAL)
          .createdAt(NOW)
          .modifiedAt(NOW)
          .build();

  MemberUserCommand.CreateRequest COMMAND_REQUEST_NORMAL =
      MemberUserCommand.CreateRequest.builder()
          .emailAddress(EmailAddress.from("normal@emailAddress.com"))
          .name("normal")
          .password("password")
          .code(AuthenticationCode.from("authCode"))
          .build();
}
