package com.boot2.hexagonal.api;

import com.boot2.hexagonal.api.command.EmailSendAuthCodeCommand;

public interface EmailUserUseCase {

  void sendAuthCode(EmailSendAuthCodeCommand.Request request);
}
