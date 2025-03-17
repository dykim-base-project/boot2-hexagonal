package com.boot2.hexagonal.api.commands;

import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Builder;

public interface MemberUserCommand {
  @Builder
  record CreateRequest(
      @Schema(description = "SNS 이메일 주소") @NotNull @Valid EmailAddress snsEmailAddress) {}
}
