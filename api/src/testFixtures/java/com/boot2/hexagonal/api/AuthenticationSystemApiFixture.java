package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.id.AuthenticationId;

public interface AuthenticationSystemApiFixture {

  AuthenticationId ID_EMAIL_NORMAL = AuthenticationId.from(EmailAddress.from("test@email.com"));

  AuthenticationSystemCommand.CreateRequest COMMAND__CREATE_REQUEST_NORMAL =
      AuthenticationSystemCommand.CreateRequest.builder()
          .id(ID_EMAIL_NORMAL)
          .build();

  AuthenticationData DATA__EMAIL_NORMAL =
      AuthenticationData.builder()
          .id(ID_EMAIL_NORMAL)
          .type(AuthenticationTypeKind.EMAIL)
          .code(AuthenticationCode.from("test code"))
          .build();

}
