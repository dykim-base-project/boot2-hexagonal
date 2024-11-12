package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.core.domains.Member;

public interface MemberMessage {

  record CreateRequest(MemberUserCommand.CreateRequest request) {}

  record CreateResponse(Member domain) {}
}
