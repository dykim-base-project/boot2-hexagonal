package com.boot2.hexagonal.core.adapter.jpa.repository;

import com.boot2.hexagonal.core.adapter.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {}
