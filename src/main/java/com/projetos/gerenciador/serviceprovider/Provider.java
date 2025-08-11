package com.projetos.gerenciador.serviceprovider;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name="profissionais")
@Entity
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone0", nullable = false)
    private String phoneNumber;

    @Column(name = "senha", unique = true, nullable = false)
    private String password;

//    @Column(name = "descricao", nullable = false)
//    private String description;


    @Column(name = "criado_em", nullable = false)
    private LocalDateTime createdAt;
}


