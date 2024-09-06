package com.boot2.hexagonal.core.domain.port;

import com.boot2.hexagonal.core.domain.message.EmailValidateMessage;

public interface EmailRepository {

  void validate(EmailValidateMessage.Request request);
}
