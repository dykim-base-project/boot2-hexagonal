package com.boot2.hexagonal.api.commands;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.enums.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface AuthenticationSystemCommand {

  @Schema(description = "인증 코드 생성 요청")
  @Builder(toBuilder = true)
  record CreateRequest(
      @Schema(description = "id") @NotNull @Valid AuthenticationId id,
      @Schema(description = "인증 타입") @NotNull AuthenticationTypeKind type) {}

  @Schema(description = "인증 코드 검증 요청")
  @Builder(toBuilder = true)
  record ValidateRequest(
      @Schema(description = "id") @NotNull @Valid AuthenticationId id,
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode code) {}
}
