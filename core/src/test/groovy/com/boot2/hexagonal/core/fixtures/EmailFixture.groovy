package com.boot2.hexagonal.core.fixtures

import com.boot2.hexagonal.api.EmailSystemApiFixture
import com.boot2.hexagonal.api.EmailUserApiFixture
import com.boot2.hexagonal.api.data.EmailAddress
import com.boot2.hexagonal.core.domains.Email

import java.time.ZonedDateTime

interface EmailFixture {

  static final def NOW = ZonedDateTime.now()
  static final def EMAIL_ADDRESS_SENDER = EmailAddress.from("sender@email.com")

  static def DOMAIN__SEND_NORMAL = Email.builder()
  .sender(EMAIL_ADDRESS_SENDER)
  .recipient(EmailSystemApiFixture.COMMAND__SEND_NORMAL.recipient())
  .subject(EmailSystemApiFixture.COMMAND__SEND_NORMAL.subject())
  .body(EmailSystemApiFixture.COMMAND__SEND_NORMAL.body())
  .sentAt(NOW)
  .build()

  static def DOMAIN__SEND_CODE_NORMAL = Email.builder()
  .sender(EMAIL_ADDRESS_SENDER)
  .build()
}