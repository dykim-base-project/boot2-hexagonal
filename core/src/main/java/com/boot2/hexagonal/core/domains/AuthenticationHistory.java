package com.boot2.hexagonal.core.domains;

import com.boot2.hexagonal.api.data.enums.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationHistoryId;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import com.boot2.hexagonal.core.domains.messages.AuthenticationHistoryMessage;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationHistory {

  private AuthenticationHistoryId id;
  private AuthenticationId authenticationId;
  private AuthenticationTypeKind type;
  private boolean authenticated;
  private WorkerId workerId;
  private ZonedDateTime createdAt;

  public static AuthenticationHistoryMessage.CreateResponse create(
      AuthenticationHistoryMessage.CreateRequest message) {
    var request = message.request();
    var authenticationHistory =
        AuthenticationHistory.builder()
            .authenticationId(request.authenticationId())
            .type(request.type())
            .authenticated(request.authenticated())
            .workerId(request.workerId())
            .createdAt(ZonedDateTime.now())
            .build();
    var response = new AuthenticationHistoryMessage.CreateResponse(authenticationHistory);
    log.info("AuthenticationHistory created: {}", response);
    return response;
  }
}
