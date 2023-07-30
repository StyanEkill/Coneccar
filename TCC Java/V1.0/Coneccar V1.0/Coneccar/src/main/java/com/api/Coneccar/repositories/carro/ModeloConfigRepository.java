package com.api.Coneccar.repositories.carro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModeloConfigRepository extends JpaRepository<com.api.Coneccar.model.carro.ModeloConfig, UUID> {
}
