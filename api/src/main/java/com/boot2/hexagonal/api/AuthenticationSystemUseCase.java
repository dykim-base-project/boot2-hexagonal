package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.commands.AuthenticationUserCommand;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface AuthenticationSystemUseCase {

  void validate(@NotNull @Valid AuthenticationSystemCommand.ValidateRequest request);
}
