package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.MemberCommand;
import com.boot2.hexagonal.core.domain.Member;

public interface MemberMessage {

  record CreateRequest(MemberCommand.CreateRequest request) {}

  record CreateResponse(Member domain) {}
}
