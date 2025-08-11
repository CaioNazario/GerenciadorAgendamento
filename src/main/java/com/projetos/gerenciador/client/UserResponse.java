package com.projetos.gerenciador.client;

public record UserResponse(Long id, String name) {
    public UserResponse(Client client) {
        this(client.getId(), client.getUsername());
    }
}
