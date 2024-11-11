package com.boot2.hexagonal.core.adapters.jpa.repositories;

import com.boot2.hexagonal.core.adapters.jpa.entities.AuthenticationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationHistoryJpaRepository
    extends JpaRepository<AuthenticationHistoryEntity, Long> {}
