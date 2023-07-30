package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Seguranca;
import com.api.Coneccar.repositories.carro.SegurancaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegurancaService {

    final SegurancaRepository segurancaRepository;

    public SegurancaService(SegurancaRepository segurancaRepository) {
        this.segurancaRepository = segurancaRepository;
    }
    @Transactional
    public Seguranca save(Seguranca segurancaModel) {
        return segurancaRepository.save(segurancaModel);
    }

    public List<Seguranca> findAll() {
        return segurancaRepository.findAll();
    }
}
