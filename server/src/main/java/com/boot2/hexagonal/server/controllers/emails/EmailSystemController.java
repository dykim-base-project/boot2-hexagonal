package com.boot2.hexagonal.server.controllers.emails;

import com.boot2.hexagonal.api.EmailSystemUseCase;
import com.boot2.hexagonal.api.commands.EmailCommand;
import com.boot2.hexagonal.api.data.EmailData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Tag(name = "시스템 이메일 API V1")
@Validated
@RequestMapping("/v1/system/emails")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
@RestController
public class EmailSystemController {

  private final EmailSystemUseCase useCase;

  @Operation(summary = "이메일 전송", description = "이메일을 전송합니다.")
  @PostMapping("send")
  public EmailData send(@RequestBody @NotNull @Valid EmailCommand.SendRequest request) {
    return useCase.send(request);
  }
}
