package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.core.domains.AuthenticationHistory;

public interface AuthenticationHistoryRepository {

  AuthenticationHistory create(AuthenticationHistory authenticationHistory);
}
