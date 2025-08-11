package com.projetos.gerenciador.serviceprovider;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

   Optional<Object> findByEmail(String email);
}
