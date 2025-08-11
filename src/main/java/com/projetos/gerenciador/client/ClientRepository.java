package com.projetos.gerenciador.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Object> findByEmail(String email);

    @Query("SELECT u FROM Client u Where u.status =1")
    List<Client> findAllActiveUsers();


}
