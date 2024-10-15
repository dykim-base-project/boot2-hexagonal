package com.boot2.hexagonal.api.command;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface MemberCreateCommand {

  @Builder
  record Request(
      @Schema(description = "이메일 주소") @NotNull @Valid EmailAddress emailAddress,
      @Schema(description = "비밀번호") @NotBlank String password,
      @Schema(description = "이름") @NotBlank String name,
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode authenticationCode) {}
}
