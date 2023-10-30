package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.repositories.carro.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Transactional
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }
    public Optional<Carro> findById(int id) {
        return carroRepository.findById(id);
    }
    @Transactional
    public void delete(Carro carro) {
        carroRepository.delete(carro);
    }
}
