package com.boot2.hexagonal.api.data.enums;

public enum EmailSendTypeKind {
  AUTHENTICATION_CODE,
  MANUAL;

  public static final int LENGTH = 30;
}
