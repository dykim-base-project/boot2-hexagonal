package com.boot2.hexagonal.server.controllers.emails

import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.boot2.hexagonal.api.EmailSystemApiFixture
import com.boot2.hexagonal.api.EmailUserApiFixture
import com.boot2.hexagonal.api.EmailUserUseCase
import com.boot2.hexagonal.api.commands.EmailUserCommand
import com.boot2.hexagonal.server.TestConfig
import com.fasterxml.jackson.databind.ObjectMapper
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@ActiveProfiles(["test"])
@Import([TestConfig])
@WebMvcTest(EmailUserController)
class EmailUserControllerSpec extends Specification{

  @Autowired
  MockMvc mvc

  @Autowired
  ObjectMapper objectMapper

  @SpringBean
  EmailUserUseCase useCase = Mock()

  def "sendCode() 성공"() {
    given:
    def commandRequest = EmailUserApiFixture.COMMAND__SEND_CODE_REQUEST
    def responseData = EmailUserApiFixture.DATA__NORMAL
    useCase.sendCode(_ as EmailUserCommand.SendCodeRequest) >> responseData

    expect:
    mvc.perform(post("/v1/user/emails/send-code")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(commandRequest)))
    .andExpect(status().isOk())
    .andExpect(content().json(objectMapper.writeValueAsString(responseData)))
  }

  def "validate() 성공"() {
    given:
    def commandRequest = EmailUserApiFixture.COMMAND__VALIDATE_REQUEST
    useCase.validate(_ as EmailUserCommand.ValidateRequest) >> null

    expect:
    mvc.perform(post("/v1/user/emails/validate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(commandRequest)))
    .andExpect(status().isOk())
    .andReturn()
  }
}
