package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.data.EmailData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailSystemUseCase {

  EmailData send(@NotNull @Valid EmailSystemCommand.SendRequest request);

  void validate(@NotNull @Valid EmailSystemCommand.ValidateRequest request);
}
