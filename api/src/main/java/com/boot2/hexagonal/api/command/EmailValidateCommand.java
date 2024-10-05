package com.boot2.hexagonal.api.command;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface EmailValidateCommand {

  @Schema(description = "이메일 검증 요청")
  @Builder(toBuilder = true)
  record Request(
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode authenticationCode) {}
}
