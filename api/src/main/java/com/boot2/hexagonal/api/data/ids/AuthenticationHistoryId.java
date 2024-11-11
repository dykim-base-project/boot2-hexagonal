package com.boot2.hexagonal.api.data.ids;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.NonNull;

public record AuthenticationHistoryId(@NotNull @JsonValue Long value) implements Serializable {

  @JsonCreator
  public static AuthenticationHistoryId from(@NonNull Long value) {
    return new AuthenticationHistoryId(value);
  }

  public static AuthenticationHistoryId from(@NonNull String value) {
    return new AuthenticationHistoryId(Long.valueOf(value));
  }

  public interface Mapper {
    default Long authenticationHistoryId(AuthenticationHistoryId value) {
      return Optional.ofNullable(value).map(AuthenticationHistoryId::value).orElse(null);
    }

    default AuthenticationHistoryId authenticationHistoryId(Long value) {
      return Optional.ofNullable(value).map(AuthenticationHistoryId::from).orElse(null);
    }
  }
}
