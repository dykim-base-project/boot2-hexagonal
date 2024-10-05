package com.boot2.hexagonal.core.domain.message;

import com.boot2.hexagonal.api.data.AuthenticationCode;

public interface EmailValidateMessage {

  record Request(AuthenticationCode authenticationCode) {}
}
