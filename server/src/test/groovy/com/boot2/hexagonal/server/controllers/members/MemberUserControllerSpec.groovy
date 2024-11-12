package com.boot2.hexagonal.server.controllers.members

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.boot2.hexagonal.api.MemberUserApiFixture
import com.boot2.hexagonal.api.MemberUserUseCase
import com.boot2.hexagonal.api.commands.MemberUserCommand
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

@ActiveProfiles(["test", "embedded-redis"])
@Import([TestConfig])
@WebMvcTest(MemberUserController)
class MemberUserControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @Autowired
    ObjectMapper objectMapper

    @SpringBean
    MemberUserUseCase useCase = Mock()

    def "create() 성공"() {
        given:
        def commandRequest = MemberUserApiFixture.COMMAND_REQUEST_NORMAL
        def responseData = MemberUserApiFixture.DATA_CREATED_NORMAL
        useCase.create(_ as MemberUserCommand.CreateRequest) >> responseData

        expect:
        mvc.perform(post("/v1/user/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commandRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseData)))
    }
}
