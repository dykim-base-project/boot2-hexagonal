package com.boot2.hexagonal.api.data.ids;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.NonNull;

public record EmailSendHistoryId(@NotNull @JsonValue Long value) implements Serializable {

  @JsonCreator
  public static EmailSendHistoryId from(@NonNull Long value) {
    return new EmailSendHistoryId(value);
  }

  public static EmailSendHistoryId from(@NonNull String value) {
    return new EmailSendHistoryId(Long.valueOf(value));
  }

  public interface Mapper {
    default Long emailSendHistoryId(EmailSendHistoryId value) {
      return Optional.ofNullable(value).map(EmailSendHistoryId::value).orElse(null);
    }

    default EmailSendHistoryId emailSendHistoryId(Long value) {
      return Optional.ofNullable(value).map(EmailSendHistoryId::from).orElse(null);
    }
  }
}
