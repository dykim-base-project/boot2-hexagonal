package com.boot2.hexagonal.api.data;

import com.boot2.hexagonal.api.data.ids.EmailSendHistoryId;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import lombok.Builder;

@Schema(description = "이메일 데이터")
@Builder
public record EmailSendHistoryData(
    @Schema(description = "id") EmailSendHistoryId id,
    @Schema(description = "발신자") EmailAddress sender,
    @Schema(description = "수신자") EmailAddress recipient,
    @Schema(description = "제목") String subject,
    @Schema(description = "내용") String body,
    @Schema(description = "발신 일시") ZonedDateTime sentAt) {}
