package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.api.commands.AuthenticationHistorySystemCommand;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import com.boot2.hexagonal.core.domains.Authentication;
import com.boot2.hexagonal.core.domains.AuthenticationHistory;
import lombok.Builder;

public interface AuthenticationHistoryMessage {

  @Builder
  record CreateRequest(AuthenticationHistorySystemCommand.CreateRequest request) {
    public static CreateRequest from(
        Authentication authentication, WorkerId workerId, boolean authenticated) {
      var commandRequest =
          AuthenticationHistorySystemCommand.CreateRequest.builder()
              .authenticationId(authentication.getId())
              .type(authentication.getType())
              .workerId(workerId)
              .authenticated(authenticated)
              .build();
      return new CreateRequest(commandRequest);
    }
  }

  record CreateResponse(AuthenticationHistory domain) {}
}
