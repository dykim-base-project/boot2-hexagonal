package com.boot2.hexagonal.core.fixtures

import com.boot2.hexagonal.api.data.AuthenticationCode
import com.boot2.hexagonal.api.data.EmailAddress
import com.boot2.hexagonal.api.data.id.AuthenticationId
import com.boot2.hexagonal.core.domains.Authentication

interface AuthenticationFixture {

  static def ID__EMAIL = AuthenticationId.from(EmailAddress.from("authentication@email.com"))

  static def DOMAIN__NORMAL = Authentication.builder()
  .id(ID__EMAIL)
  .code(AuthenticationCode.from("123456"))
  .build()
}
