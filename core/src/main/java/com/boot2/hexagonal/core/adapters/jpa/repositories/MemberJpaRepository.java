package com.boot2.hexagonal.core.adapters.jpa.repositories;

import com.boot2.hexagonal.core.adapters.jpa.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {}
