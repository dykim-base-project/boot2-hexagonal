package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.core.adapters.jpa.mappers.MemberJpaMapper;
import com.boot2.hexagonal.core.adapters.jpa.repositories.MemberJpaRepository;
import com.boot2.hexagonal.core.domains.Member;
import com.boot2.hexagonal.core.domains.ports.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

  private final MemberJpaRepository repository;
  private final MemberJpaMapper mapper;

  @Override
  public Member create(Member member) {
    var entity = mapper.toEntity(member);
    var savedEntity = repository.save(entity);
    return mapper.toDomain(savedEntity);
  }
}
