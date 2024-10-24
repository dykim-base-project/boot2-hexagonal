package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.EmailCommand;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailData;

import java.time.ZonedDateTime;

public interface EmailApiFixture {

  ZonedDateTime NOW = ZonedDateTime.now();

  EmailCommand.SendRequest COMMAND__SEND_NORMAL = EmailCommand.SendRequest.builder()
          .recipient(EmailAddress.from("test@email.com"))
          .subject("test subject")
          .body("test body")
          .build();

  EmailData DATA__NORMAL = EmailData.builder()
          .subject(COMMAND__SEND_NORMAL.subject())
          .body(COMMAND__SEND_NORMAL.body())
          .recipient(COMMAND__SEND_NORMAL.recipient())
          .sentAt(NOW)
          .build();
}
