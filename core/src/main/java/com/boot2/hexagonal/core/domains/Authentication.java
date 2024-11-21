package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.enums.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.api.exceptions.AuthenticationInvalidException;
import com.boot2.hexagonal.core.domains.messages.AuthenticationMessage;
import java.security.SecureRandom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {

  private AuthenticationId id;
  private AuthenticationTypeKind type;
  private AuthenticationCode code;

  public static AuthenticationMessage.CreateResponse create(
      AuthenticationMessage.CreateRequest message) {
    var request = message.request();
    var authentication =
        Authentication.builder()
            .id(request.id())
            .type(request.type())
            .code(AuthenticationCode.from(generateRandomNum(6)))
            .build();
    log.info("Authentication created: {}", authentication);
    return new AuthenticationMessage.CreateResponse(authentication);
  }

  public void validate(AuthenticationMessage.ValidateRequest message) {
    var request = message.request();
    if (!request.code().equals(this.code)) {
      log.error("Invalid authentication code: {}", request);
      throw new AuthenticationInvalidException();
    }
    log.info("Authentication valid: {}", this);
  }

  @SneakyThrows
  private static long generateRandomNum(int length) {
    var upperLimit = (int) Math.pow(10, length);
    return SecureRandom.getInstanceStrong().nextLong(upperLimit);
  }
}
