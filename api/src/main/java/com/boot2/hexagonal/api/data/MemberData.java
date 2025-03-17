package com.boot2.hexagonal.api.data;

import com.boot2.hexagonal.api.data.enums.MemberStatusKind;
import com.boot2.hexagonal.api.data.ids.MemberId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import lombok.Builder;

@Schema(description = "회원 데이터")
@Builder(toBuilder = true)
public record MemberData(
    @Schema(description = "회원 id") MemberId id,
    @Schema(description = "SNS 이메일 주소") EmailAddress snsEmailAddress,
    @Schema(description = "회원 상태") MemberStatusKind status,
    @Schema(description = "생성 일시") ZonedDateTime createdAt,
    @Schema(description = "생성자 Id") WorkerId creatorId,
    @Schema(description = "수정 일시") ZonedDateTime modifiedAt,
    @Schema(description = "수정자 Id") WorkerId modifierId) {}
