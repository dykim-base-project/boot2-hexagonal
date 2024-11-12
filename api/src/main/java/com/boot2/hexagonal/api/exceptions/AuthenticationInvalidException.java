package com.boot2.hexagonal.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "authentication.invalid.exception")
public class AuthenticationInvalidException extends RuntimeException {}
