package com.boot2.hexagonal.core.domains.mappers;

import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.ids.MemberId;
import com.boot2.hexagonal.core.domains.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MemberMapper extends MemberId.Mapper {

  MemberData map(Member member);
}
