package com.boot2.hexagonal.core.domain.port;

import com.boot2.hexagonal.core.domain.Member;

public interface MemberRepository {

  Member create(Member member);
}
