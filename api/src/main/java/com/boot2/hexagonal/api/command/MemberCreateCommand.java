package com.boot2.hexagonal.api.command;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface MemberCreateCommand {

  @Builder
  record Request(
      @Schema(description = "이메일") @NotNull String email,
      @Schema(description = "비밀번호") @NotNull String password,
      @Schema(description = "이름") @NotNull String name,
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode authenticationCode) {}
}
