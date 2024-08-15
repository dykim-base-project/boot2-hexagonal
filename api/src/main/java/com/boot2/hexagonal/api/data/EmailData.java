package com.boot2.hexagonal.api.data;

import io.swagger.v3.oas.annotations.media.Schema;

public record EmailData(
    @Schema(description = "이메일") String email, @Schema(description = "인증 코드") String authCode) {}
