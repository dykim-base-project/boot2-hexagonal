package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import com.boot2.hexagonal.api.EmailSystemApiFixture
import com.boot2.hexagonal.api.EmailSystemUseCase
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand
import com.boot2.hexagonal.core.domains.Email
import com.boot2.hexagonal.core.domains.ports.EmailPort
import com.boot2.hexagonal.core.fixtures.EmailFixture
import org.spockframework.spring.SpringBean
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
class EmailSystemServiceSpec extends Specification {

  @Autowired
  EmailSystemUseCase useCase

  @SpringBean
  EmailPort port = Mock()

  @SpringBean
  AuthenticationSystemUseCase authenticationSystemUseCase = Mock()

  def "send() 성공"() {
    given:
    def request = EmailSystemApiFixture.COMMAND__SEND_NORMAL

    when:
    useCase.send(request)

    then:
    noExceptionThrown()
    1 * port.send(_ as Email) >> EmailFixture.DOMAIN__SEND_NORMAL
  }

  def "validate() 성공"() {
    given:
    def request = EmailSystemApiFixture.COMMAND__VALIDATE_NORMAL

    when:
    useCase.validate(request)

    then:
    noExceptionThrown()
    1 * authenticationSystemUseCase.validate(_ as AuthenticationSystemCommand.ValidateRequest)
  }
}
