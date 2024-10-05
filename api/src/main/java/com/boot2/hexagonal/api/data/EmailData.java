package com.boot2.hexagonal.api.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "이메일 데이터")
@Builder
public record EmailData(
    @Schema(description = "이메일") String email,
    @Schema(description = "인증 코드") AuthenticationCode authenticationCode) {}
