package com.projetos.gerenciador.user;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="usuarios")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", unique = true, nullable = false)
    private String password;



}
