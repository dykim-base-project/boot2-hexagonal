package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.EmailValidateCommand;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailSystemUseCase {

  void validate(@NotNull @Valid EmailValidateCommand.Request request);
}
