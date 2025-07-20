package com.projetos.gerenciador.exception;

import org.springframework.http.HttpStatus;

// this enum works like central catalog of all possible errors of the application
public enum ErrCode {
    USER_NOTFOUND("USER-001","Usuario não encontrado", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_EXISTS("USER-002", "Email já cadastrado", HttpStatus.CONFLICT)
    ;
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

