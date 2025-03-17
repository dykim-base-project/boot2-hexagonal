package com.boot2.hexagonal.core;

import com.boot2.hexagonal.api.MemberUserUseCase;
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

  @Override
  public MemberData create(MemberUserCommand.CreateRequest request) {
    var messageResponse = Member.create(new MemberMessage.CreateRequest(request));
    var savedMember = repository.create(messageResponse.domain());
    return mapper.map(savedMember);
  }
}
