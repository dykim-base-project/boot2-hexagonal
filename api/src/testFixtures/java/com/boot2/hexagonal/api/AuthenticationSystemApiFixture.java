package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.data.AuthenticationTypeKind;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.ids.AuthenticationId;

public interface AuthenticationSystemApiFixture {

  AuthenticationId ID_EMAIL_NORMAL = AuthenticationId.from(EmailAddress.from("test@email.com"));
  AuthenticationId ID_EMAIL_CREATED = AuthenticationId.from(EmailAddress.from("created@email.com"));

  AuthenticationSystemCommand.CreateRequest COMMAND__CREATE_REQUEST_EMAIL_NORMAL =
      AuthenticationSystemCommand.CreateRequest.builder()
          .id(ID_EMAIL_NORMAL)
          .type(AuthenticationTypeKind.EMAIL)
          .build();

  AuthenticationSystemCommand.CreateRequest COMMAND__CREATE_REQUEST_EMAIL_CREATED =
      AuthenticationSystemCommand.CreateRequest.builder()
          .id(ID_EMAIL_CREATED)
          .type(AuthenticationTypeKind.EMAIL)
          .build();

  AuthenticationSystemCommand.ValidateRequest COMMAND__VALIDATE_REQUEST_NOT_FOUND =
      AuthenticationSystemCommand.ValidateRequest.builder()
          .id(AuthenticationId.from("not found"))
          .code(AuthenticationCode.from("invalid code"))
          .build();

  AuthenticationSystemCommand.ValidateRequest COMMAND__VALIDATE_REQUEST_INVALID_CODE =
      AuthenticationSystemCommand.ValidateRequest.builder()
          .id(ID_EMAIL_CREATED)
          .code(AuthenticationCode.from("Invalid!"))
          .build();

  AuthenticationData DATA__EMAIL_NORMAL =
      AuthenticationData.builder()
          .id(ID_EMAIL_NORMAL)
          .type(AuthenticationTypeKind.EMAIL)
          .code(AuthenticationCode.from("test code"))
          .build();
}
