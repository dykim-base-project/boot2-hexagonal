package com.boot2.hexagonal.core

import static com.boot2.hexagonal.api.AuthenticationSystemApiFixture.*

import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@Transactional
@ActiveProfiles(["test", "embedded-redis"])
@Import([TestConfig])
@SpringBootTest(classes = [CoreTestApplication.class])
class AuthenticationSystemServiceSpec extends Specification {

  @Autowired
  AuthenticationSystemUseCase useCase

  def "create() 성공 - #caseName"() {
    when:
    def responseData = useCase.create(request)

    then:
    noExceptionThrown()
    responseData.code() != null
    println(responseData)

    where:
    caseName | request
    "이메일" | COMMAND__CREATE_REQUEST_EMAIL_NORMAL
  }
}
