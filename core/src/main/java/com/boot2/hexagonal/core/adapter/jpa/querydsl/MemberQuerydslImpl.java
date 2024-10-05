package com.boot2.hexagonal.core.adapter.jpa.querydsl;

import com.boot2.hexagonal.core.adapter.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberQuerydslImpl extends QuerydslRepositorySupport implements MemberQuerydsl {

  public MemberQuerydslImpl() {
    super(MemberEntity.class);
  }
}
