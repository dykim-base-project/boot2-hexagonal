package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.id.AuthenticationId;
import com.boot2.hexagonal.core.domains.messages.AuthenticationMessage.SendCodeToEmailRequest;
import com.boot2.hexagonal.core.domains.messages.AuthenticationMessage.SendCodeToEmailResponse;
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

  public static SendCodeToEmailResponse sendCodeToEmail(SendCodeToEmailRequest message) {
    var request = message.request();
    var authentication =
        Authentication.builder()
            .id(AuthenticationId.from(request.emailAddress()))
            .type(AuthenticationTypeKind.EMAIL)
            .code(AuthenticationCode.from(generateRandomNum(6)))
            .build();
    log.info("Send email authentication code: {}", authentication);
    return new SendCodeToEmailResponse(authentication);
  }

  @SneakyThrows
  private static long generateRandomNum(int length) {
    var upperLimit = (int) Math.pow(10, length);
    return SecureRandom.getInstanceStrong().nextLong(upperLimit);
  }
}
