package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.api.data.id.AuthenticationId;
import com.boot2.hexagonal.core.domains.Authentication;
import java.util.Optional;

public interface AuthenticationRepository {

  Optional<Authentication> findBy(AuthenticationId id);

  Authentication create(Authentication authentication);
}
