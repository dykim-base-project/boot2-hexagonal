package com.boot2.hexagonal.api.commands;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface AuthenticationSystemCommand {

  @Schema(description = "인증 코드 검증 요청")
  @Builder(toBuilder = true)
  record ValidateRequest(
          @Schema(description = "id") @NotNull @Valid AuthenticationId id,
          @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode authenticationCode) {}
}
