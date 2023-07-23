package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Modelo;
import com.api.Coneccar.repositories.carro.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository){
        this.modeloRepository = modeloRepository;
    }
    @Transactional
    public Modelo save(Modelo modeloModel) {
        return modeloRepository.save(modeloModel);
    }
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }
}
