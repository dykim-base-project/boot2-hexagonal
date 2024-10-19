package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.EmailCommand;
import com.boot2.hexagonal.api.data.EmailData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailSystemUseCase {

  EmailData send(@NotNull @Valid EmailCommand.SendRequest request);

  void validate(@NotNull @Valid EmailCommand.ValidateRequest request);
}
