package com.boot2.hexagonal.server.controllers.emails

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.boot2.hexagonal.api.EmailSystemApiFixture
import com.boot2.hexagonal.api.EmailSystemUseCase
import com.boot2.hexagonal.api.commands.EmailSystemCommand
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
@WebMvcTest(EmailSystemController)
class EmailSystemControllerSpec extends Specification{

  @Autowired
  MockMvc mvc

  @Autowired
  ObjectMapper objectMapper

  @SpringBean
  EmailSystemUseCase useCase = Mock()

  def "send() 성공"() {
    given:
    def commandRequest = EmailSystemApiFixture.COMMAND__SEND_NORMAL
    def responseData = EmailSystemApiFixture.DATA__NORMAL
    useCase.send(_ as EmailSystemCommand.SendRequest) >> responseData

    expect:
    mvc.perform(post("/v1/system/emails/send")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(commandRequest)))
    .andExpect(status().isOk())
    .andExpect(content().json(objectMapper.writeValueAsString(responseData)))
  }

  def "validate() 성공"() {
    given:
    def commandRequest = EmailSystemApiFixture.COMMAND__VALIDATE_NORMAL
    useCase.validate(_ as EmailSystemCommand.ValidateRequest) >> null

    expect:
    mvc.perform(post("/v1/system/emails/validate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(commandRequest)))
    .andExpect(status().isOk())
    .andReturn()
  }
}
