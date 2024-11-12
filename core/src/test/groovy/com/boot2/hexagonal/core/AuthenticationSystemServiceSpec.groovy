package com.boot2.hexagonal.core

import static com.boot2.hexagonal.api.AuthenticationSystemApiFixture.*

import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand
import com.boot2.hexagonal.api.data.AuthenticationData
import com.boot2.hexagonal.api.exceptions.AuthenticationInvalidException
import com.boot2.hexagonal.api.exceptions.AuthenticationNotFoundException
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared
import spock.lang.Specification

@Transactional
@ActiveProfiles(["test", "embedded-redis"])
@Import([TestConfig])
@SpringBootTest(classes = [CoreTestApplication.class])
class AuthenticationSystemServiceSpec extends Specification {

  @Autowired
  AuthenticationSystemUseCase useCase

  @Shared
  AuthenticationData createdAuthentication

  def setup() {
    createdAuthentication = useCase.create(COMMAND__CREATE_REQUEST_EMAIL_CREATED)
  }

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

  def "validate() 성공"() {
    given:
    def request = AuthenticationSystemCommand.ValidateRequest.builder()
    .id(createdAuthentication.id())
    .code(createdAuthentication.code())
    .build()

    when:
    useCase.validate(request)

    then:
    noExceptionThrown()
  }

  def "validate() 실패 - #caseName"() {
    when:
    useCase.validate(request)

    then:
    thrown(exception)

    where:
    caseName | request | exception
    "인증 정보 없음" | COMMAND__VALIDATE_REQUEST_NOT_FOUND | AuthenticationNotFoundException
    "인증 코드 맞지 않음" | COMMAND__VALIDATE_REQUEST_INVALID_CODE | AuthenticationInvalidException
  }
}
