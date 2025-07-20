package com.projetos.gerenciador.exception;

import java.time.LocalDateTime;


public record ApiError(
        LocalDateTime timestamp,
        int status,
        String message,
        String code,
        String path
) {}