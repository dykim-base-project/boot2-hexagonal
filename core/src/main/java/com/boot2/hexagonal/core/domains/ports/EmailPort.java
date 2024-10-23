package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.core.domains.Email;

public interface EmailPort {

  Email send(Email email);

  void validate(Email email);
}
