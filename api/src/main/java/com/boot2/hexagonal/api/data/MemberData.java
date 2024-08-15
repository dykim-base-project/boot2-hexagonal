package com.boot2.hexagonal.api.data;

import com.boot2.hexagonal.api.data.id.MemberId;
import io.swagger.v3.oas.annotations.media.Schema;

public record MemberData(
    @Schema(description = "회원 id") MemberId id,
    @Schema(description = "이메일") String email,
    @Schema(description = "이름") String name,
    @Schema(description = "회원 상태") MemberStatus status) {}
