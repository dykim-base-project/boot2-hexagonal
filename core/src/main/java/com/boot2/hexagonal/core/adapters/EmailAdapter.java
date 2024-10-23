package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.ports.EmailPort;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailAdapter implements EmailPort {

  private final MailSender mailSender;

  @Value("${smtp.sender}")
  private String sender;

  @Override
  public Email send(Email email) {
    email.setSender(EmailAddress.from(sender));
    var simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom(email.getSender().value());
    simpleMailMessage.setTo(email.getRecipient().value());
    simpleMailMessage.setSubject(email.getSubject());
    simpleMailMessage.setText(email.getBody());
    simpleMailMessage.setSentDate(Date.from(email.getSentAt().toInstant()));
    mailSender.send(simpleMailMessage);
    return email;
  }

  @Override
  public void validate(Email email) {}
}
