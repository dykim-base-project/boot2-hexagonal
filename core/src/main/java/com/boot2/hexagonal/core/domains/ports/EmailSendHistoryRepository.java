package com.boot2.hexagonal.core.domains.ports;

import com.boot2.hexagonal.core.domains.EmailSendHistory;

public interface EmailSendHistoryRepository {

  EmailSendHistory create(EmailSendHistory emailSendHistory);
}
