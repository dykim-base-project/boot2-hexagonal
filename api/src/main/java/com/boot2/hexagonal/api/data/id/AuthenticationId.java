package com.boot2.hexagonal.api.data.id;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record AuthenticationId(@NotBlank @JsonValue String value) {

  @JsonCreator
  public static AuthenticationId from(@NonNull String value) {
    return new AuthenticationId(value);
  }

  public static AuthenticationId from(@NonNull EmailAddress emailAddress) {
    return new AuthenticationId(emailAddress.value());
  }

  public interface Mapper {
    default AuthenticationId authenticationId(String value) {
      return Optional.ofNullable(value)
          .filter(v -> !v.isBlank())
          .map(AuthenticationId::from)
          .orElse(null);
    }

    default String authenticationId(AuthenticationId id) {
      return Optional.ofNullable(id).map(AuthenticationId::value).orElse(null);
    }
  }
}
