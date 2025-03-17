package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.enums.MemberStatusKind;
import com.boot2.hexagonal.api.data.ids.MemberId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import java.time.ZonedDateTime;

public interface MemberUserApiFixture {
  MemberId ID_NORMAL = MemberId.from(1L);
  ZonedDateTime NOW = ZonedDateTime.now();

  MemberUserCommand.CreateRequest CREATE_REQUEST =
      MemberUserCommand.CreateRequest.builder()
          .snsEmailAddress(EmailAddress.from("request@snsEmailAddress.com"))
          .build();

  MemberData DATA_CREATED_NORMAL =
      MemberData.builder()
          .id(ID_NORMAL)
          .snsEmailAddress(CREATE_REQUEST.snsEmailAddress())
          .status(MemberStatusKind.NORMAL)
          .createdAt(NOW)
          .creatorId(WorkerId.system())
          .modifiedAt(NOW)
          .modifierId(WorkerId.system())
          .build();
}
