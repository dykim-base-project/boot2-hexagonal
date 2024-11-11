package com.boot2.hexagonal.api.commands;

import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.api.data.ids.WorkerId;
import lombok.Builder;

public interface AuthenticationHistorySystemCommand {

  @Builder(toBuilder = true)
  record CreateRequest(
      AuthenticationId authenticationId,
      AuthenticationTypeKind type,
      boolean authenticated,
      WorkerId workerId) {}
}
