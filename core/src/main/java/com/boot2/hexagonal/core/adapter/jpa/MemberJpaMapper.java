package com.boot2.hexagonal.core.adapter.jpa;

import com.boot2.hexagonal.api.data.id.MemberId;
import com.boot2.hexagonal.core.adapter.jpa.entity.MemberEntity;
import com.boot2.hexagonal.core.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberJpaMapper extends MemberId.Mapper {

  Member toDomain(MemberEntity entity);

  MemberEntity toEntity(Member member);
}
