package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.core.domains.Authentication;

public interface AuthenticationRepository {

  Authentication create(Authentication authentication);

  void validate(Authentication authentication);
}
