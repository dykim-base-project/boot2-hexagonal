package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.MemberCreateCommand;
import com.boot2.hexagonal.api.data.MemberData;

public interface MemberUserUseCase {

  MemberData create(MemberCreateCommand.Request request);
}
