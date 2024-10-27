package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface AuthenticationSystemUseCase {

  AuthenticationData create(@NotNull @Valid AuthenticationSystemCommand.CreateRequest request);

  void validate(@NotNull @Valid AuthenticationSystemCommand.ValidateRequest request);
}
