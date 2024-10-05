package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.MemberUserUseCase;
import com.boot2.hexagonal.api.command.EmailValidateCommand;
import com.boot2.hexagonal.api.command.MemberCreateCommand;
import com.boot2.hexagonal.api.data.MemberData;
import com.boot2.hexagonal.core.domain.Member;
import com.boot2.hexagonal.core.domain.MemberMapper;
import com.boot2.hexagonal.core.domain.message.MemberCreateMessage;
import com.boot2.hexagonal.core.domain.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@RequiredArgsConstructor
public class MemberUserService implements MemberUserUseCase {

  private final MemberRepository repository;
  private final MemberMapper mapper;

  // TODO: 이메일 useCase adapter 에서 조립하기
  private final EmailSystemUseCase emailSystemUseCase;

  @Override
  public MemberData create(MemberCreateCommand.Request request) {
    var emailValidateRequest =
        EmailValidateCommand.Request.builder()
            .authenticationCode(request.authenticationCode())
            .build();
    emailSystemUseCase.validate(emailValidateRequest);

    var messageResponse = Member.create(new MemberCreateMessage.Request(request));
    var savedMember = repository.create(messageResponse.member());
    return mapper.toMemberData(savedMember);
  }
}
