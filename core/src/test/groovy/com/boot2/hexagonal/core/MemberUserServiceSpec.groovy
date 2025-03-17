package com.boot2.hexagonal.core

import com.boot2.hexagonal.api.MemberUserApiFixture
import com.boot2.hexagonal.api.MemberUserUseCase
import javax.transaction.Transactional
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

    def "create() 성공"() {
        given:
        def request = MemberUserApiFixture.CREATE_REQUEST
        def expectData = MemberUserApiFixture.DATA_CREATED_NORMAL

        when:
        def responseData = memberUserUseCase.create(request)
        expectData = expectData.toBuilder().createdAt(responseData.createdAt()).modifiedAt(responseData.modifiedAt()).build()

        then:
        noExceptionThrown()
        responseData == expectData
    }
}
