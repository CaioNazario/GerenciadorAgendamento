package com.projetos.gerenciador.serviceprovider;

public record CreateProviderRequest(
        String name,
        String email,
//        String description,
        String password
){}
