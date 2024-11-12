package com.boot2.hexagonal.core.domains.messages;

import com.boot2.hexagonal.core.domains.Email;
import com.boot2.hexagonal.core.domains.EmailSendHistory;

public interface EmailSendHistoryMessage {

  record CreateRequest(Email email) {}

  record CreateResponse(EmailSendHistory domain) {}
}
