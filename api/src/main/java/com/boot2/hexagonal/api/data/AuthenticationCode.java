package com.boot2.hexagonal.api.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import lombok.NonNull;

public record AuthenticationCode(@NotBlank @JsonValue String value) {

  @JsonCreator
  public static AuthenticationCode from(@NonNull String value) {
    return new AuthenticationCode(value);
  }

  public interface Mapper {
    default String map(AuthenticationCode value) {
      return Optional.ofNullable(value).map(AuthenticationCode::value).orElse(null);
    }

    default AuthenticationCode map(String value) {
      return Optional.ofNullable(value).map(AuthenticationCode::from).orElse(null);
    }
  }
}
