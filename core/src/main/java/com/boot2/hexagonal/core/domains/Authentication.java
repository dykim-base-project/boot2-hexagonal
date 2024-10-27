package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
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
            .type(AuthenticationTypeKind.EMAIL)
            .code(AuthenticationCode.from(generateRandomNum(6)))
            .build();
    log.info("Create authentication: {}", authentication);
    return new AuthenticationMessage.CreateResponse(authentication);
  }

  public AuthenticationMessage.ValidateResponse validate(
      AuthenticationMessage.ValidateRequest message) {
    var request = message.request();
    if (!request.code().equals(this.code)) {
      log.error("Invalid authentication code: {}", request);
      return new AuthenticationMessage.ValidateResponse(false);
    }
    log.info("Validate authentication code: {}", this);
    return new AuthenticationMessage.ValidateResponse(true);
  }

  @SneakyThrows
  private static long generateRandomNum(int length) {
    var upperLimit = (int) Math.pow(10, length);
    return SecureRandom.getInstanceStrong().nextLong(upperLimit);
  }
}
