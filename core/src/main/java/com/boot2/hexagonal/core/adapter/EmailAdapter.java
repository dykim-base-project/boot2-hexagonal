package com.boot2.hexagonal.core.adapter;

import com.boot2.hexagonal.core.domain.Email;
import com.boot2.hexagonal.core.domain.port.EmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailAdapter implements EmailPort {

  private final MailSender mailSender;

  @Override
  public void send(Email email) {
    mailSender.send();
  }

  @Override
  public void validate(Email email) {}
}
