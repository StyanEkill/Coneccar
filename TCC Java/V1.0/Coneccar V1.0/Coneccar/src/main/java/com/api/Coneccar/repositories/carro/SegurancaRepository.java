package com.api.Coneccar.repositories.carro;

import com.api.Coneccar.model.carro.Seguranca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SegurancaRepository extends JpaRepository<Seguranca, UUID> {
}
