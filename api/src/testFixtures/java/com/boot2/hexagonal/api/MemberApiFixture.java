package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.MemberCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.MemberStatus;
import com.boot2.hexagonal.api.data.id.MemberId;
import java.time.ZonedDateTime;

public interface MemberApiFixture {
  MemberId ID_NORMAL = MemberId.from(1L);
  ZonedDateTime NOW = ZonedDateTime.now();
  MemberCommand.CreateRequest COMMAND_CREATE =
      MemberCommand.CreateRequest.builder()
          .name("name")
          .emailAddress(EmailAddress.from("request@emailAddress.com"))
          .authenticationCode(AuthenticationCode.from("test"))
          .password("password")
          .build();

  MemberData DATA_CREATED_NORMAL =
      MemberData.builder()
          .id(ID_NORMAL)
          .emailAddress(COMMAND_CREATE.emailAddress())
          .name(COMMAND_CREATE.name())
          .status(MemberStatus.NORMAL)
          .createdAt(NOW)
          .modifiedAt(NOW)
          .build();

  MemberCommand.CreateRequest COMMAND_REQUEST_NORMAL =
      MemberCommand.CreateRequest.builder()
          .emailAddress(EmailAddress.from("normal@emailAddress.com"))
          .name("normal")
          .password("password")
          .authenticationCode(AuthenticationCode.from("authCode"))
          .build();
}
