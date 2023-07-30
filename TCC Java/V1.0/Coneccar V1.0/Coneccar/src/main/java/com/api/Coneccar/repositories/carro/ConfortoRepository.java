package com.api.Coneccar.repositories.carro;

import com.api.Coneccar.model.carro.Conforto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConfortoRepository extends JpaRepository<Conforto, UUID> {
}
