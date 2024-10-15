package com.boot2.hexagonal.api.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Optional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record EmailAddress(@NotBlank @Size(max = MAX_LENGTH) @Email String value) {
  public static final int MAX_LENGTH = 254;

  @JsonCreator
  public static EmailAddress from(@NotNull String value) {
    return new EmailAddress(value);
  }

  public interface Mapper {
    default String map(EmailAddress emailAddress) {
      return Optional.ofNullable(emailAddress).map(EmailAddress::value).orElse(null);
    }

    default EmailAddress map(String value) {
      return Optional.ofNullable(value).map(EmailAddress::from).orElse(null);
    }
  }
}
