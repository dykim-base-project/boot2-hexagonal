package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.api.data.ids.AuthenticationId;
import com.boot2.hexagonal.core.adapters.redis.mappers.AuthenticationRedisRepositoryMapper;
import com.boot2.hexagonal.core.adapters.redis.repositories.AuthenticationRedisRepository;
import com.boot2.hexagonal.core.domains.Authentication;
import com.boot2.hexagonal.core.domains.ports.AuthenticationRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

  private final AuthenticationRedisRepository repository;
  private final AuthenticationRedisRepositoryMapper mapper;

  @Override
  public Optional<Authentication> findBy(AuthenticationId id) {
    return repository.findById(id.value()).map(mapper::map);
  }

  @Override
  public Authentication create(Authentication authentication) {
    var entity = mapper.map(authentication);
    var savedEntity = repository.save(entity);
    return mapper.map(savedEntity);
  }
}
