package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.MemberCommand;
import com.boot2.hexagonal.core.domains.Member;

public interface MemberMessage {

  record CreateRequest(MemberCommand.CreateRequest request) {}

  record CreateResponse(Member domain) {}
}
