package com.projetos.gerenciador.user;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String service;
}
