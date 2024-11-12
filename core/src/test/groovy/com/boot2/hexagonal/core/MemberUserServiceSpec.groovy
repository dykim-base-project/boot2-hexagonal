package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.EmailSystemUseCase
import com.boot2.hexagonal.api.MemberUserApiFixture
import com.boot2.hexagonal.api.MemberUserUseCase
import com.boot2.hexagonal.api.commands.EmailSystemCommand
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
class MemberUserServiceSpec extends Specification {

    @Autowired
    MemberUserUseCase memberUserUseCase

    @SpringBean
    EmailSystemUseCase emailSystemUseCase = Mock()

    def "create() 성공"() {
        given:
        def request = MemberUserApiFixture.COMMAND_CREATE
        def expectData = MemberUserApiFixture.DATA_CREATED_NORMAL

        when:
        def responseData = memberUserUseCase.create(request)
        expectData = expectData.toBuilder().createdAt(responseData.createdAt()).modifiedAt(responseData.modifiedAt()).build()

        then:
        noExceptionThrown()
        responseData == expectData
        1 * emailSystemUseCase.validate(_ as EmailSystemCommand.ValidateRequest)
    }
}
