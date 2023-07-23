package com.api.Coneccar.repositories.carro;

import com.api.Coneccar.model.carro.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModeloRepository extends JpaRepository<Modelo, UUID> {

    List<Modelo> findById(int id);
}
