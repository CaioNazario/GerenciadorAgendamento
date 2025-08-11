package com.projetos.gerenciador.client;

public record UpdateClientRequest(

        String name,
        String email,
        String password
) {}
