package com.boot2.hexagonal.server.controllers.emails;

import com.boot2.hexagonal.api.EmailUserUseCase;
import com.boot2.hexagonal.api.commands.EmailUserCommand;
import com.boot2.hexagonal.api.data.EmailData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "사용자용 이메일 API V1")
@Validated
@RequestMapping("/v1/user/emails")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@RestController
public class EmailUserController {

  private final EmailUserUseCase useCase;

  @Operation(summary = "인증 코드 전송", description = "이메일로 인증 코드를 전송합니다.")
  @PostMapping("send-code")
  public EmailData sendCode(@NotNull @Valid @RequestBody EmailUserCommand.SendCodeRequest request) {
    return useCase.sendCode(request);
  }

  @Operation(summary = "이메일 검증", description = "이메일을 검증합니다.")
  @PostMapping("validate")
  public void validate(@NotNull @Valid @RequestBody EmailUserCommand.ValidateRequest request) {
    useCase.validate(request);
  }
}
