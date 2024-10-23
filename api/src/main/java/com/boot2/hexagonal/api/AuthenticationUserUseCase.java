package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.AuthenticationCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface AuthenticationUserUseCase {

  @Schema(description = "인증 코드 발송(이메일)")
  AuthenticationData sendCodeToEmail(
      @NotNull @Valid AuthenticationCommand.SendCodeToEmailRequest request);
}
