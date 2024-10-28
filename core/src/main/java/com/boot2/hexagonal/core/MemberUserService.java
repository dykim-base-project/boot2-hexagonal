package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.MemberUserUseCase;
import com.boot2.hexagonal.api.commands.EmailSystemCommand;
import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.core.domains.Member;
import com.boot2.hexagonal.core.domains.mappers.MemberMapper;
import com.boot2.hexagonal.core.domains.messages.MemberMessage;
import com.boot2.hexagonal.core.domains.ports.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@RequiredArgsConstructor
public class MemberUserService implements MemberUserUseCase {

  private final MemberRepository repository;
  private final MemberMapper mapper;

  private final EmailSystemUseCase emailSystemUseCase;

  @Override
  public MemberData create(MemberUserCommand.CreateRequest request) {
    var emailValidateRequest =
        EmailSystemCommand.ValidateRequest.builder()
                                          .emailAddress(request.emailAddress())
                                          .code(request.code())
                                          .build();
    emailSystemUseCase.validate(emailValidateRequest);

    var messageResponse = Member.create(new MemberMessage.CreateRequest(request));
    var savedMember = repository.create(messageResponse.domain());
    return mapper.map(savedMember);
  }
}
