package com.api.Coneccar.services.carro;

import com.api.Coneccar.repositories.carro.ModeloConfigRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloConfigService {

    final ModeloConfigRepository modeloConfigRepository;

    public ModeloConfigService(ModeloConfigRepository modeloConfigRepository) {
        this.modeloConfigRepository = modeloConfigRepository;
    }
    @Transactional
    public com.api.Coneccar.model.carro.ModeloConfig save(com.api.Coneccar.model.carro.ModeloConfig modeloConfigModel) {
        return modeloConfigRepository.save(modeloConfigModel);
    }

    public List<com.api.Coneccar.model.carro.ModeloConfig> findAll() {
        return modeloConfigRepository.findAll();
    }
}
