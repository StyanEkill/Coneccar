package com.api.Coneccar.repositories;

import com.api.Coneccar.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarroRepository extends JpaRepository<Carro, UUID> {

    Optional<Carro> findById(int id);
}
