package com.api.Coneccar.services;

import com.api.Coneccar.model.Carro;
import com.api.Coneccar.model.User;
import com.api.Coneccar.repositories.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }
    @Transactional
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

}
