package com.boot2.hexagonal.api.commands;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface AuthenticationCommand {

  @Schema(description = "인증 코드 발송 요청(이메일)")
  record SendCodeToEmailRequest(
      @Schema(description = "이메일 주소") @NotNull @Valid EmailAddress emailAddress) {}

  @Schema(description = "인증 코드 검증 요청")
  @Builder(toBuilder = true)
  record ValidateRequest(
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode authenticationCode) {}
}
