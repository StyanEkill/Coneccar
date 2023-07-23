package com.api.Coneccar.repositories;

import com.api.Coneccar.model.CarroModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarroModeloRepository extends JpaRepository<CarroModelo, UUID> {

    List<CarroModelo> findById(int id);
}
