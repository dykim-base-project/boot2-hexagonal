package com.boot2.hexagonal.core.adapters;

import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.ports.EmailPort;
import java.util.Date;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailAdapter implements EmailPort {

  private final JavaMailSender mailSender;

  @Value("${smtp.sender}")
  private String sender;

  @SneakyThrows(MessagingException.class)
  @Override
  public Email send(Email email) {
    email.setSender(EmailAddress.from(sender));
    var mimeMessage = mailSender.createMimeMessage();
    mimeMessage.setFrom(email.getSender().value());
    mimeMessage.setRecipients(RecipientType.TO, email.getRecipient().value());
    mimeMessage.setSubject(email.getSubject());
    mimeMessage.setContent(email.getBody(), "text/html; charset=UTF-8");
    mimeMessage.setSentDate(Date.from(email.getSentAt().toInstant()));
    mailSender.send(mimeMessage);
    return email;
  }
}
