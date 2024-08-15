package com.boot2.hexagonal.api.command;

public interface EmailSendAuthCodeCommand {

  record Request(String email) {}
}
