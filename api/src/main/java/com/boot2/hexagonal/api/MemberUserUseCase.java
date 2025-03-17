package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.MemberData;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface MemberUserUseCase {

  /**
   *
   *
   * <h3>회원 생성</h3>
   *
   * @param request 생성 요청
   * @return 생성 결과 데이터
   */
  MemberData create(@NotNull @Valid MemberUserCommand.CreateRequest request);
}
