package com.boot2.hexagonal.server.controllers.members;

import com.boot2.hexagonal.api.MemberUserUseCase;
import com.boot2.hexagonal.api.commands.MemberUserCommand;
import com.boot2.hexagonal.api.data.MemberData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "사용자용 회원 API V1")
@Validated
@RequestMapping("/v1/user/members")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@RestController
public class MemberUserController {

  private final MemberUserUseCase memberUserUseCase;

  @Operation(summary = "회원 생성", description = "회원을 생성합니다. 이메일 인증 여부를 확인합니다.")
  @PostMapping
  public MemberData create(@RequestBody MemberUserCommand.CreateRequest request) {
    return memberUserUseCase.create(request);
  }
}
