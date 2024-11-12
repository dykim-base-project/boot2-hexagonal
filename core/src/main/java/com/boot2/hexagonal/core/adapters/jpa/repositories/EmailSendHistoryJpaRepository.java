package com.boot2.hexagonal.core.adapters.jpa.repositories;

import com.boot2.hexagonal.core.adapters.jpa.entities.EmailSendHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailSendHistoryJpaRepository
    extends JpaRepository<EmailSendHistoryEntity, Long> {}
