package com.boot2.hexagonal.core.domain.port;

import com.boot2.hexagonal.core.domain.EmailSendHistory;

public interface EmailSendHistoryRepository {

  EmailSendHistory create(EmailSendHistory emailSendHistory);
}
