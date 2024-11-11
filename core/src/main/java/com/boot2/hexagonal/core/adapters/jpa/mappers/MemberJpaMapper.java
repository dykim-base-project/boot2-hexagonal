package com.boot2.hexagonal.core.adapters.jpa.mappers;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.ids.MemberId;
import com.boot2.hexagonal.core.adapters.jpa.entities.MemberEntity;
import com.boot2.hexagonal.core.domains.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MemberJpaMapper extends MemberId.Mapper, EmailAddress.Mapper {

  Member toDomain(MemberEntity entity);

  MemberEntity toEntity(Member member);
}
