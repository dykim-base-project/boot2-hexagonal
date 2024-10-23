package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.core.domains.Member;

public interface MemberRepository {

  Member create(Member member);
}
