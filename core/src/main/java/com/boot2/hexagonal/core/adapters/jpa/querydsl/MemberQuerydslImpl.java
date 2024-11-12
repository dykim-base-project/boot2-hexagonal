package com.boot2.hexagonal.core.adapters.jpa.querydsl;

import com.boot2.hexagonal.core.adapters.jpa.entities.MemberEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberQuerydslImpl extends QuerydslRepositorySupport implements MemberQuerydsl {

  public MemberQuerydslImpl() {
    super(MemberEntity.class);
  }
}
