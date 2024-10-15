package com.boot2.hexagonal.core.adapter;

import com.boot2.hexagonal.core.adapter.jpa.mapper.MemberJpaMapper;
import com.boot2.hexagonal.core.adapter.jpa.repository.MemberJpaRepository;
import com.boot2.hexagonal.core.domain.Member;
import com.boot2.hexagonal.core.domain.port.MemberRepository;
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
