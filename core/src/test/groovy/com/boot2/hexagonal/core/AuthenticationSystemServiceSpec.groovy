package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.AuthenticationSystemApiFixture
import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import javax.transaction.Transactional

@Transactional
@ActiveProfiles(["test", "embedded-redis"])
@Import([TestConfig])
@SpringBootTest(classes = [CoreTestApplication.class])
class AuthenticationSystemServiceSpec extends Specification {

  @Autowired
  AuthenticationSystemUseCase useCase

  // TODO: Embedded redis 테스트 에러 발생
  def "create() 성공"() {
    given:
    def request = AuthenticationSystemApiFixture.COMMAND__CREATE_REQUEST_NORMAL

    when:
    def responseData = useCase.create(request)

    then:
    noExceptionThrown()
    responseData.code() != null
  }
}
