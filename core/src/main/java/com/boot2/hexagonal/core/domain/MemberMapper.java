package com.boot2.hexagonal.core.domain;

import com.boot2.hexagonal.api.data.MemberData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

  MemberData toMemberData(Member member);
}
