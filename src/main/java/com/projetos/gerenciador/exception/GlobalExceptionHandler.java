package com.projetos.gerenciador.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException ex, WebRequest request) {
        ErrCode errCode = ex.getErrCode();

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
           errCode.getHttpStatus().value(),
           errCode.getMessage(),
           errCode.getCode(),
           request.getDescription(false)
        );
        return new ResponseEntity<>(apiError, errCode.getHttpStatus());

    }


}
