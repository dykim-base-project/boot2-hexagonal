package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailData;
import java.time.ZonedDateTime;

public interface EmailSystemApiFixture {

  ZonedDateTime NOW = ZonedDateTime.now();

  EmailSystemCommand.SendRequest COMMAND__SEND_NORMAL =
      EmailSystemCommand.SendRequest.builder()
          .recipient(EmailAddress.from("test@email.com"))
          .subject("test subject")
          .body("test body")
          .build();

  EmailSystemCommand.ValidateRequest COMMAND__VALIDATE_NORMAL =
      EmailSystemCommand.ValidateRequest.builder()
          .emailAddress(COMMAND__SEND_NORMAL.recipient())
          .code(AuthenticationCode.from("test value"))
          .build();

  EmailData DATA__NORMAL =
      EmailData.builder()
          .subject(COMMAND__SEND_NORMAL.subject())
          .body(COMMAND__SEND_NORMAL.body())
          .recipient(COMMAND__SEND_NORMAL.recipient())
          .sentAt(NOW)
          .build();
}
