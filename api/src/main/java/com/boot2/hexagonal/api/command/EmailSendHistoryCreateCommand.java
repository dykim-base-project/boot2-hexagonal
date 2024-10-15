package com.boot2.hexagonal.api.command;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface EmailSendHistoryCreateCommand {

  @Schema(description = "이메일 발송 기록 저장 요청")
  @Builder
  record Request(
      @Schema(description = "발신자", requiredMode = REQUIRED) @NotNull @Valid EmailAddress from,
      @Schema(description = "수신자", requiredMode = REQUIRED) @NotNull @Valid EmailAddress to,
      @Schema(description = "제목", requiredMode = REQUIRED) @NotBlank String subject,
      @Schema(description = "내용", requiredMode = REQUIRED) @NotBlank String body,
      @Schema(description = "발신 일시", requiredMode = REQUIRED) @NotNull ZonedDateTime sentAt) {}
}
