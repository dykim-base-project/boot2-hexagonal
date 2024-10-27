package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.EmailData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailUserUseCase {

  EmailData sendCode(@NotNull @Valid EmailUserCommand.SendCodeRequest request);

  void validate(@NotNull @Valid EmailUserCommand.ValidateRequest request);
}
