package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.EmailSendCommand;
import com.boot2.hexagonal.api.command.EmailValidateCommand;
import com.boot2.hexagonal.api.data.EmailData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EmailSystemUseCase {

  EmailData send(@NotNull @Valid EmailSendCommand.Request request);

  void validate(@NotNull @Valid EmailValidateCommand.Request request);
}
