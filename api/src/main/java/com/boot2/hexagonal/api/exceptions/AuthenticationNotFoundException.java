package com.boot2.hexagonal.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "authentication.not.found.exception")
public class AuthenticationNotFoundException extends RuntimeException {}
