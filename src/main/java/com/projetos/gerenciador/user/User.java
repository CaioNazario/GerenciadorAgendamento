package com.projetos.gerenciador.user;


import jakarta.persistence.*;
import lombok.Data;


@Data //set all the getters and setters
@Entity
@Table(name="usuarios")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true )
    private String email;

    @Column(name = "senha", unique = true, nullable = false)
    private String password;



    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;

}
