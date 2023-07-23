package com.api.Coneccar.repositories.carro;

import com.api.Coneccar.model.carro.CarroRelacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarroRelacionamentoRepository extends JpaRepository<CarroRelacionamento, UUID> {


}
