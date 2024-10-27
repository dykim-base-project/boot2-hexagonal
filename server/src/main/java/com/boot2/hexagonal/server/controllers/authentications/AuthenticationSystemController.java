package com.boot2.hexagonal.server.controllers.authentications;

import com.boot2.hexagonal.api.AuthenticationSystemUseCase;
import com.boot2.hexagonal.api.commands.AuthenticationSystemCommand;
import com.boot2.hexagonal.api.data.AuthenticationData;
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

@Tag(name = "시스템용 인증 API V1")
@Validated
@RequestMapping("/v1/system/authentications")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@RestController
public class AuthenticationSystemController {

  private final AuthenticationSystemUseCase useCase;

  @Operation(summary = "생성", description = "인증 정보를 생성합니다.")
  @PostMapping
  public AuthenticationData create(
      @NotNull @Valid @RequestBody AuthenticationSystemCommand.CreateRequest request) {
    return useCase.create(request);
  }
}
