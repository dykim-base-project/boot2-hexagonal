package com.boot2.hexagonal.api.data;

import com.boot2.hexagonal.api.data.id.AuthenticationId;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;

@Schema(description = "인증 데이터")
@Builder
public record AuthenticationData(
    @Schema(description = "id. 인증 타입에 대한 값", requiredMode = RequiredMode.REQUIRED)
        AuthenticationId id,
    @Schema(description = "인증 타입", requiredMode = RequiredMode.REQUIRED)
        AuthenticationTypeKind type,
    @Schema(description = "인증 코드", requiredMode = RequiredMode.REQUIRED) AuthenticationCode code) {}
