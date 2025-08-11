package com.projetos.gerenciador.client;

public record UpdateClientResponse(

        String name,
        String email,
        String password
) {}
