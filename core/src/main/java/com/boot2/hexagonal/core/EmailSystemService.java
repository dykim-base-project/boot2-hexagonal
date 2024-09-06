package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.command.EmailValidateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
public class EmailSystemService implements EmailSystemUseCase {

  @Override
  public void validate(EmailValidateCommand.Request request) {}
}
