package com.boot2.hexagonal.core.domain.port;

import com.boot2.hexagonal.core.domain.Email;

public interface EmailPort {

  void send(Email email);

  void validate(Email email);
}
