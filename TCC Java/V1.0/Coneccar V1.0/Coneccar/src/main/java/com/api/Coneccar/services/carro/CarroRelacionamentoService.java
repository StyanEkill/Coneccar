package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.carro.CarroRelacionamento;
import com.api.Coneccar.repositories.carro.CarroRelacionamentoRepository;
import com.api.Coneccar.repositories.carro.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroRelacionamentoService {

    final CarroRelacionamentoRepository carroRelacionamentoRepository;

    public CarroRelacionamentoService(CarroRelacionamentoRepository carroRelacionamentoRepository) {
        this.carroRelacionamentoRepository = carroRelacionamentoRepository;
    }

    @Transactional
    public CarroRelacionamento save(CarroRelacionamento carroRelacionamento) {
        return carroRelacionamentoRepository.save(carroRelacionamento);
    }

    public List<CarroRelacionamento> findAll() {
        return carroRelacionamentoRepository.findAll();
    }

}
