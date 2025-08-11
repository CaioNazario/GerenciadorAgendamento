package com.projetos.gerenciador.client;

import jakarta.validation.constraints.NotBlank;

public record CreateClientRequest(

        @NotBlank(message = "O nome não pode estar vazio")
        String name,
        @NotBlank(message = "O email não pode estar vazio")
        String email,
        @NotBlank(message = "O email não pode estar vazio")
        String password
) {}
