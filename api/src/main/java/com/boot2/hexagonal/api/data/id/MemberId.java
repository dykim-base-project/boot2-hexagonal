package com.boot2.hexagonal.api.data.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.NonNull;

public record MemberId(@NotNull @JsonValue Long value) implements Serializable {

  @JsonCreator
  public static MemberId from(@NonNull Long value) {
    return new MemberId(value);
  }

  public static MemberId from(@NonNull String value) {
    return new MemberId(Long.valueOf(value));
  }

  public interface Mapper {
    default Long map(MemberId value) {
      return Optional.ofNullable(value).map(MemberId::value).orElse(null);
    }

    default MemberId map(Long value) {
      return Optional.ofNullable(value).map(MemberId::from).orElse(null);
    }
  }
}
