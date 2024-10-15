package com.boot2.hexagonal.core.adapter;

import com.boot2.hexagonal.core.adapter.jpa.mapper.EmailSendHistoryJpaMapper;
import com.boot2.hexagonal.core.adapter.jpa.repository.EmailSendHistoryJpaRepository;
import com.boot2.hexagonal.core.domain.EmailSendHistory;
import com.boot2.hexagonal.core.domain.port.EmailSendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EmailSendHistoryRepositoryImpl implements EmailSendHistoryRepository {

  private final EmailSendHistoryJpaRepository jpaRepository;
  private final EmailSendHistoryJpaMapper mapper;

  @Override
  public EmailSendHistory create(EmailSendHistory emailSendHistory) {
    var entity = mapper.map(emailSendHistory);
    var savedEntity = jpaRepository.save(entity);
    return mapper.map(savedEntity);
  }
}
