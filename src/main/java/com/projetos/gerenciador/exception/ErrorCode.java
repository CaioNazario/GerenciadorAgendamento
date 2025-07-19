package com.projetos.gerenciador.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// this enum works like central catalog of all possible errors of the application
@Getter
public enum ApiError {

    EMAIL_ALREADY_EXISTS("USER-002", "Email já cadastrado", HttpStatus.CONFLICT);
    ;
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ApiError(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}

