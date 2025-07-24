package com.projetos.gerenciador.user;


import jakarta.persistence.*;
import lombok.Data;



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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
