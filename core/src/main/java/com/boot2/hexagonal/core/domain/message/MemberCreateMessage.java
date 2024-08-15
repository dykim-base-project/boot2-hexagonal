package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.command.MemberCreateCommand;
import com.boot2.hexagonal.core.domain.Member;

public interface MemberCreateMessage {

  record Request(MemberCreateCommand.Request request) {}

  record Response(Member member) {}
}
