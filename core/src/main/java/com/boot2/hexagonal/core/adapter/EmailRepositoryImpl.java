package com.boot2.hexagonal.core.adapter;

import com.boot2.hexagonal.core.domain.message.EmailValidateMessage;
import com.boot2.hexagonal.core.domain.port.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EmailRepositoryImpl implements EmailRepository {
  @Override
  public void validate(EmailValidateMessage.Request request) {}
}
