package com.boot2.hexagonal.server.controllers.authentications

import com.boot2.hexagonal.api.AuthenticationSystemApiFixture
import com.boot2.hexagonal.api.AuthenticationSystemUseCase
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ActiveProfiles(["test"])
@Import([TestConfig])
@WebMvcTest(AuthenticationSystemController)
class AuthenticationSystemControllerSpec extends Specification {

  @Autowired
  MockMvc mvc

  @Autowired
  ObjectMapper objectMapper

  @SpringBean
  AuthenticationSystemUseCase useCase = Mock()

  def "create() 성공"() {
    given:
    def commandRequest = AuthenticationSystemApiFixture.COMMAND__CREATE_REQUEST_NORMAL
    def responseData = AuthenticationSystemApiFixture.DATA__EMAIL_NORMAL
    useCase.create(_ as AuthenticationSystemCommand.CreateRequest) >> responseData

    expect:
    mvc.perform(post("/v1/system/authentications")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(commandRequest)))
    .andExpect(status().isOk())
    .andExpect(content().json(objectMapper.writeValueAsString(responseData)))
  }
}
