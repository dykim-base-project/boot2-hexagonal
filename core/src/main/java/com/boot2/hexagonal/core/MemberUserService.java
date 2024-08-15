package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.MemberUserUseCase;
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

  @Override
  public MemberData create(MemberCreateCommand.Request request) {
    // TODO 이메일 인증 여부 확인

    var messageResponse = Member.create(new MemberCreateMessage.Request(request));
    var savedMember = repository.create(messageResponse.member());
    return mapper.toMemberData(savedMember);
  }
}
