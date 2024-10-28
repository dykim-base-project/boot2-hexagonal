package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.AuthenticationCode;
import com.boot2.hexagonal.api.data.EmailAddress;
import com.boot2.hexagonal.api.data.EmailData;
import java.time.ZonedDateTime;

public interface EmailUserApiFixture {

  ZonedDateTime NOW = ZonedDateTime.now();

  EmailUserCommand.SendCodeRequest COMMAND__SEND_CODE_REQUEST =
    EmailUserCommand.SendCodeRequest.builder()
                                    .emailAddress(EmailAddress.from("test@email.com"))
                                    .build();

  EmailUserCommand.ValidateRequest COMMAND__VALIDATE_REQUEST =
    EmailUserCommand.ValidateRequest.builder()
                                    .emailAddress(COMMAND__SEND_CODE_REQUEST.emailAddress())
                                    .code(AuthenticationCode.from("test value"))
                                    .build();

  EmailData DATA__NORMAL =
    EmailData.builder()
        .recipient(COMMAND__SEND_CODE_REQUEST.emailAddress())
        .sentAt(NOW)
        .build();
}
