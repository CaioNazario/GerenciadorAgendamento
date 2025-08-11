package com.projetos.gerenciador.client;




import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;


@Entity
@Table(name="clientes")
@Data
public class Client {


//    now called client, not user.
//    refactored to not have login.
//    email column deleted

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String username;

    @Column(name = "numero_whatsapp", unique = true, nullable = false)
    private String whatsappNumber;

    @Column(name = "ultima_atividade", nullable = false)
    private ZonedDateTime lastActivity;

    @Column(name = "tem_marcacao", nullable = false)
    private boolean haveAppointment;

    @Column(name = "data_criacao", nullable = false)
    private ZonedDateTime createdAt;




}
