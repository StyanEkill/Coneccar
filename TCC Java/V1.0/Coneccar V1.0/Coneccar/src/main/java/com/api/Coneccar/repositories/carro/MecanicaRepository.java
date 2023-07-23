package com.api.Coneccar.repositories.carro;

import com.api.Coneccar.model.carro.Mecanica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MecanicaRepository extends JpaRepository<Mecanica, UUID> {



}
