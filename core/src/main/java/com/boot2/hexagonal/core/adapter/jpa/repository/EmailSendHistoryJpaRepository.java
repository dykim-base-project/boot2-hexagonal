package com.boot2.hexagonal.core.adapter.jpa.repository;

import com.boot2.hexagonal.core.adapter.jpa.entity.EmailSendHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailSendHistoryJpaRepository
    extends JpaRepository<EmailSendHistoryEntity, Long> {}
