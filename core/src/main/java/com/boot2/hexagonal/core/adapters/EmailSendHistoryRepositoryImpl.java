package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.core.adapters.jpa.mappers.EmailSendHistoryJpaMapper;
import com.boot2.hexagonal.core.adapters.jpa.repositories.EmailSendHistoryJpaRepository;
import com.boot2.hexagonal.core.domains.EmailSendHistory;
import com.boot2.hexagonal.core.domains.ports.EmailSendHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EmailSendHistoryRepositoryImpl implements EmailSendHistoryRepository {

  private final EmailSendHistoryJpaRepository repository;
  private final EmailSendHistoryJpaMapper mapper;

  @Override
  public EmailSendHistory create(EmailSendHistory emailSendHistory) {
    var entity = mapper.map(emailSendHistory);
    var savedEntity = repository.save(entity);
    return mapper.map(savedEntity);
  }
}
