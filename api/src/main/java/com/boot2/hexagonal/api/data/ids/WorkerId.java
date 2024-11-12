package com.boot2.hexagonal.api.data.ids;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.lang.NonNull;

public record WorkerId(@NotBlank @Size(max = MAX_LENGTH) @JsonValue String value)
    implements Serializable {

  public static final int MAX_LENGTH = 30;

  @JsonCreator
  public static WorkerId from(@NonNull String value) {
    return new WorkerId(value);
  }

  public static WorkerId from(@NonNull MemberId memberId) {
    return new WorkerId(memberId.stringValue());
  }

  public static WorkerId system() {
    return new WorkerId("SYSTEM");
  }

  public interface Mapper {
    default WorkerId workerId(String value) {
      return Optional.ofNullable(value).filter(v -> !v.isBlank()).map(WorkerId::from).orElse(null);
    }

    default String workerId(WorkerId id) {
      return Optional.ofNullable(id).map(WorkerId::value).orElse(null);
    }
  }
}
