package com.boot2.hexagonal.core.domain.mapper;

import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.api.data.id.MemberId;
import com.boot2.hexagonal.core.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper extends MemberId.Mapper {

  MemberData toMemberData(Member member);
}
