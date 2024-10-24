package com.boot2.hexagonal.server.controllers.authentications;

import com.boot2.hexagonal.api.AuthenticationUserUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationUserCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
import com.boot2.hexagonal.api.data.EmailAddress;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "사용자용 인증 API V1")
@Validated
@RequestMapping("/v1/user/authentications")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@RestController
public class AuthenticationUserController {

  private final AuthenticationUserUseCase useCase;

  @Operation(summary = "인증 번호 발송(이메일)", description = "이메일로 인증 번호를 발송합니다.")
  @GetMapping("/send-code-to-email/{emailAddress}")
  public AuthenticationData sendCodeToEmail(@PathVariable @NotBlank String emailAddress) {
    var request = new AuthenticationUserCommand.SendCodeToEmailRequest(EmailAddress.from(emailAddress));
    return useCase.sendCodeToEmail(request);
  }
}
