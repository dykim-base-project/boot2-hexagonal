package com.boot2.hexagonal.api.commands;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface EmailCommand {

  @Schema(description = "전송 요청")
  @Builder(toBuilder = true)
  record SendRequest(
      @Schema(description = "수신자", requiredMode = REQUIRED) @NotNull @Valid EmailAddress recipient,
      @Schema(description = "제목", requiredMode = REQUIRED) @NotBlank String subject,
      @Schema(description = "내용", requiredMode = REQUIRED) @NotBlank String body) {}

  @Schema(description = "이메일 검증 요청")
  @Builder(toBuilder = true)
  record ValidateRequest(
      @Schema(description = "이메일 주소") @NotNull @Valid EmailAddress emailAddress,
      @Schema(description = "인증 코드") @NotNull @Valid AuthenticationCode code) {}
}
