package com.boot2.hexagonal.api.command;

import io.swagger.v3.oas.annotations.media.Schema;

public interface MemberCreateCommand {

  record Request(
      @Schema(description = "이메일") String email,
      @Schema(description = "비밀번호") String password,
      @Schema(description = "이름") String name,
      @Schema(description = "인증 코드") String authCode) {}
}
