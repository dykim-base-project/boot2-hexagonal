package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.MemberData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface MemberUserUseCase {

  MemberData create(@NotNull @Valid MemberUserCommand.CreateRequest request);
}
