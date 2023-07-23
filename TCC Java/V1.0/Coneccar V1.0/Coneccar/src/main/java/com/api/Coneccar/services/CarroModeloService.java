package com.api.Coneccar.services;

import com.api.Coneccar.model.Carro;
import com.api.Coneccar.model.CarroModelo;
import com.api.Coneccar.repositories.CarroModeloRepository;
import com.api.Coneccar.repositories.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroModeloService {
    final CarroModeloRepository carroModeloRepository;

    public CarroModeloService(CarroModeloRepository carroModeloRepository){
        this.carroModeloRepository = carroModeloRepository;
    }
    @Transactional
    public CarroModelo save(CarroModelo carroModeloModel) {
        return carroModeloRepository.save(carroModeloModel);
    }
    public List<CarroModelo> findAll() {
        return carroModeloRepository.findAll();
    }
}
