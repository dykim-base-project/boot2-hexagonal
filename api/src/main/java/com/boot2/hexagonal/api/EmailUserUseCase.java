package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.EmailCommand;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailUserUseCase {

  void sendAuthenticationCode(@NotNull @Valid EmailCommand.SendRequest request);
}
