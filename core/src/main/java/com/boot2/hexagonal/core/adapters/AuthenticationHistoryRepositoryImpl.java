package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.core.adapters.jpa.mappers.AuthenticationHistoryJpaMapper;
import com.boot2.hexagonal.core.adapters.jpa.repositories.AuthenticationHistoryJpaRepository;
import com.boot2.hexagonal.core.domains.AuthenticationHistory;
import com.boot2.hexagonal.core.domains.ports.AuthenticationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AuthenticationHistoryRepositoryImpl implements AuthenticationHistoryRepository {

  private final AuthenticationHistoryJpaRepository jpaRepository;
  private final AuthenticationHistoryJpaMapper mapper;

  @Override
  public AuthenticationHistory create(AuthenticationHistory authenticationHistory) {
    var entity = mapper.map(authenticationHistory);
    var savedEntity = jpaRepository.save(entity);
    return mapper.map(savedEntity);
  }
}
