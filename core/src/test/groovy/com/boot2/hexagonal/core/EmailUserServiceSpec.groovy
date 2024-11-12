package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.AuthenticationSystemApiFixture
import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import com.boot2.hexagonal.api.EmailUserApiFixture
import com.boot2.hexagonal.api.EmailUserUseCase
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand
import com.boot2.hexagonal.core.domains.Email
import com.boot2.hexagonal.core.domains.ports.EmailPort
import com.boot2.hexagonal.core.fixtures.EmailFixture
import javax.transaction.Transactional
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@Transactional
@ActiveProfiles(["test"])
@Import([TestConfig])
@SpringBootTest(classes = [CoreTestApplication.class])
class EmailUserServiceSpec extends Specification {

  @Autowired
  EmailUserUseCase useCase

  @SpringBean
  EmailPort port = Mock()

  @SpringBean
  AuthenticationSystemUseCase authenticationSystemUseCase = Mock()

  def "sendCode() 성공"() {
    given:
    def request = EmailUserApiFixture.COMMAND__SEND_CODE_REQUEST

    when:
    useCase.sendCode(request)

    then:
    noExceptionThrown()
    1 * authenticationSystemUseCase.create(_ as AuthenticationSystemCommand.CreateRequest) >> AuthenticationSystemApiFixture.DATA__EMAIL_NORMAL
    1 * port.send(_ as Email) >> EmailFixture.DOMAIN__SEND_CODE_NORMAL
  }

  def "validate() 성공"() {
    given:
    def request = EmailUserApiFixture.COMMAND__VALIDATE_REQUEST

    when:
    useCase.validate(request)

    then:
    noExceptionThrown()
    1 * authenticationSystemUseCase.validate(_ as AuthenticationSystemCommand.ValidateRequest)
  }
}
